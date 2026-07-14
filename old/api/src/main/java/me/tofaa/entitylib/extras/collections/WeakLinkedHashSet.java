package me.tofaa.entitylib.extras.collections;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.*;

/**
 * A {@link Set} with weak element references and stable insertion-order iteration.
 * Stale nodes are purged lazily on every public operation.
 *
 * <p><strong>Not thread-safe.</strong>
 *
 * @param <E> element type
 */
public final class WeakLinkedHashSet<E> extends AbstractSet<E> {

    private final class Node extends WeakReference<E> {

        Node prev;
        Node next;

        Node(E referent, Node prev, Node next) {
            super(referent, queue);
            this.prev = prev;
            this.next = next;
        }

        void unlink() {
            prev.next = next;
            next.prev = prev;
            prev = null;
            next = null;
        }
    }


    private final Node sentinel;

    private final IdentityHashMap<E, Node> index;

    /** GC enqueues nodes here when their referents are collected. */
    private final ReferenceQueue<E> queue = new ReferenceQueue<>();

    private int size = 0;

    public WeakLinkedHashSet() {
        this(16);
    }

    public WeakLinkedHashSet(int initialCapacity) {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        index = new IdentityHashMap<>(initialCapacity);
    }

    @SuppressWarnings("unchecked")
    private void purgeStale() {
        Node stale;
        while ((stale = (Node) queue.poll()) != null) {
            if (stale.next != null) {   // TODO
                stale.unlink();
                size--;
                // We cannot remove from index here because we have lost the key.
                // The index entry will be cleaned at the next add/remove/contains
                // that encounters the same slot, or left until clear().
            }
        }
    }

    @Override
    public boolean add(E e) {
        Objects.requireNonNull(e, "null elements not permitted");
        purgeStale();
        if (index.containsKey(e)) return false;

        Node node = new Node(e, sentinel.prev, sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;

        index.put(e, node);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) return false;
        purgeStale();
        @SuppressWarnings("unchecked")
        Node node = index.remove((E) o);
        if (node == null) return false;

        node.unlink();
        size--;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) return false;
        purgeStale();
        Node node = index.get(o);
        // The node might still be in the index but its referent already collected
        return node != null && node.get() != null;
    }

    @Override
    public void clear() {
        purgeStale();
        Node cur = sentinel.next;
        while (cur != sentinel) {
            Node next = cur.next;
            cur.prev = cur.next = null;   // help GC
            cur = next;
        }
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        index.clear();
        size = 0;
    }

    @Override
    public int size() {
        purgeStale();
        return size;
    }

    @Override
    public boolean isEmpty() {
        purgeStale();
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        purgeStale();
        return new Iterator<E>() {
            private Node cursor = sentinel.next;
            private E next = null;

            @Override
            public boolean hasNext() {
                while (next == null && cursor != sentinel) {
                    next = cursor.get();
                    cursor = cursor.next;
                }
                return next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E result = next;
                next = null;
                return result;
            }
        };
    }
}

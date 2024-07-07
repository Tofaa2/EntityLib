package me.tofaa.entitylib.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ELVersion implements Comparable<ELVersion> {

    private final int major;
    private final int minor;
    private final int patch;
    private final boolean snapshot;

    /**
     * Constructs a {@link ELVersion} instance.
     *
     * @param major    the major version number.
     * @param minor    the minor version number.
     * @param patch    the patch version number.
     * @param snapshot whether the version is a snapshot.
     */
    public ELVersion(final int major, final int minor, final int patch, final boolean snapshot) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.snapshot = snapshot;
    }

    /**
     * Constructs a {@link ELVersion} instance with snapshot defaulted to false.
     *
     * @param major the major version number.
     * @param minor the minor version number.
     * @param patch the patch version number.
     */
    public ELVersion(final int major, final int minor, final int patch) {
        this(major, minor, patch, false);
    }

    /**
     * Constructs a {@link ELVersion} instance from a version string.
     *
     * @param version the version string (e.g., "1.8.9-SNAPSHOT").
     * @throws IllegalArgumentException if the version string format is incorrect.
     */
    public static ELVersion fromString(@NotNull final String version) {
        String versionWithoutSnapshot = version.replace("-SNAPSHOT", "");
        String[] parts = versionWithoutSnapshot.split("\\.");

        if (parts.length < 2 || parts.length > 3) {
            throw new IllegalArgumentException("Version string must be in the format 'major.minor[.patch][-SNAPSHOT]' found '" + version + "' instead.");
        }

        int major = Integer.parseInt(parts[0]);
        int minor = Integer.parseInt(parts[1]);
        int patch = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;
        boolean snapshot = version.contains("-SNAPSHOT");

        return new ELVersion(major, minor, patch, snapshot);
    }

    /**
     * Gets the major version number.
     *
     * @return the major version number.
     */
    public int major() {
        return major;
    }

    /**
     * Gets the minor version number.
     *
     * @return the minor version number.
     */
    public int minor() {
        return minor;
    }

    /**
     * Gets the patch version number.
     *
     * @return the patch version number.
     */
    public int patch() {
        return patch;
    }

    /**
     * Checks if the version is a snapshot.
     *
     * @return true if snapshot, false otherwise.
     */
    public boolean snapshot() {
        return snapshot;
    }

    /**
     * Compares this {@link ELVersion} with another {@link ELVersion}.
     *
     * @param other the other {@link ELVersion}.
     * @return a negative integer, zero, or a positive integer as this version is less than,
     * equal to, or greater than the specified version.
     */
    @Override
    public int compareTo(@NotNull final ELVersion other) {
        int majorCompare = Integer.compare(this.major, other.major);
        if (majorCompare != 0) return majorCompare;

        int minorCompare = Integer.compare(this.minor, other.minor);
        if (minorCompare != 0) return minorCompare;

        int patchCompare = Integer.compare(this.patch, other.patch);
        if (patchCompare != 0) return patchCompare;

        return Boolean.compare(other.snapshot, this.snapshot);
    }

    /**
     * Checks if the provided object is equal to this {@link ELVersion}.
     *
     * @param obj the object to compare.
     * @return true if the provided object is equal to this {@link ELVersion}, false otherwise.
     */
    @Override
    public boolean equals(@NotNull final Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ELVersion)) return false;
        ELVersion other = (ELVersion) obj;

        return this.major == other.major &&
                this.minor == other.minor &&
                this.patch == other.patch &&
                this.snapshot == other.snapshot;
    }

    /**
     * Checks if this version is newer than the provided version.
     *
     * @param otherVersion the other {@link ELVersion}.
     * @return true if this version is newer, false otherwise.
     */
    public boolean isNewerThan(@NotNull final ELVersion otherVersion) {
        return this.compareTo(otherVersion) > 0;
    }

    /**
     * Checks if this version is older than the provided version.
     *
     * @param otherVersion the other {@link ELVersion}.
     * @return true if this version is older, false otherwise.
     */
    public boolean isOlderThan(@NotNull final ELVersion otherVersion) {
        return this.compareTo(otherVersion) < 0;
    }

    /**
     * Returns a hash code value for this {@link ELVersion}.
     *
     * @return a hash code value.
     */
    @Override
    public int hashCode() {
        return Objects.hash(major, minor, patch, snapshot);
    }

    /**
     * Creates and returns a copy of this {@link ELVersion}.
     *
     * @return a clone of this instance.
     */
    @Override
    public ELVersion clone() {
        return new ELVersion(major, minor, patch, snapshot);
    }

    /**
     * Converts the {@link ELVersion} to a string representation.
     *
     * @return a string representation of the version.
     */
    @Override
    public String toString() {
        return major + "." + minor + "." + patch + (snapshot ? "-SNAPSHOT" : "");
    }
}


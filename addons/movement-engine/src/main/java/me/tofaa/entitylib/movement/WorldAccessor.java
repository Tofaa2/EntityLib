package me.tofaa.entitylib.movement;

public interface WorldAccessor {

    WorldAccessor EMPTY = new WorldAccessor() {
        @Override
        public boolean isLoaded(int x, int z) {
            return true;
        }

        @Override
        public boolean isSolid(int x, int y, int z) {
            return false;
        }

        @Override
        public boolean isLiquid(int x, int y, int z) {
            return false;
        }
    };

    static WorldAccessor flat(int groundY) {
        return new WorldAccessor() {
            @Override
            public boolean isLoaded(int x, int z) {
                return true;
            }

            @Override
            public boolean isSolid(int x, int y, int z) {
                return y < groundY;
            }

            @Override
            public boolean isLiquid(int x, int y, int z) {
                return false;
            }
        };
    }

    boolean isLoaded(int x, int z);

    boolean isSolid(int x, int y, int z);

    boolean isLiquid(int x, int y, int z);

}

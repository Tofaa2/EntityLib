// This class is generated by code-gen module. Do not edit manually.
//
package me.tofaa.entitylib.meta;

import static me.tofaa.entitylib.EntityLib.getApi;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@SuppressWarnings("unused")
public final class MetaOffsetConverter {
    private MetaOffsetConverter() {
    }

    public static final class EntityMetaOffsets {
        private EntityMetaOffsets() {
        }

        public static byte airTicksOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 47 && protocolVersion <= 767) {
                return 1;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte customNameOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 47 && protocolVersion <= 767) {
                return 2;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte customNameVisibleOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 47 && protocolVersion <= 767) {
                return 3;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte silentOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 47 && protocolVersion <= 767) {
                return 4;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte hasNoGravityOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 47 && protocolVersion <= 767) {
                return 5;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte poseOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 47 && protocolVersion <= 767) {
                return 6;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte ticksFrozenInPowderedSnowOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 47 && protocolVersion <= 767) {
                return 7;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }
    }

    public static final class AbstractDisplayMetaOffsets {
        private AbstractDisplayMetaOffsets() {
        }

        public static byte interpolationDelayOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 762 && protocolVersion <= 767) {
                return 8;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte transformationDurationOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 762 && protocolVersion <= 767) {
                return 9;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte positionRotationInterpolationDurationOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 10;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte translationOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 11;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 10;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte scaleOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 12;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 11;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte leftRotationOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 13;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 12;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte rightRotationOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 14;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 13;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte billboardConstraintsOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 15;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 14;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte brightnessOverrideOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 16;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 15;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte viewRangeOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 17;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 16;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte shadowRadiusOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 18;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 17;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte shadowStrengthOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 19;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 18;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte widthOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 20;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 19;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte heightOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 21;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 20;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte glowColorOverrideOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 22;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 21;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }
    }

    public static final class BlockDisplayMetaOffsets {
        private BlockDisplayMetaOffsets() {
        }

        public static byte blockIdOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 23;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 22;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }
    }

    public static final class ItemDisplayMetaOffsets {
        private ItemDisplayMetaOffsets() {
        }

        public static byte itemOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 24;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 23;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte displayTypeOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 25;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 24;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }
    }

    public static final class TextDisplayMetaOffsets {
        private TextDisplayMetaOffsets() {
        }

        public static byte textOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 26;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 25;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte textColorOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 27;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 26;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte textBackgroundColorOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 28;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 27;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte textBackgroundOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 29;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 28;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte textScaleOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 30;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 29;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte textAlignmentOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 31;
            }
            if (protocolVersion >= 762 && protocolVersion <= 767) {
                return 30;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte lineWidthOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 32;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 31;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte backgroundColorOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 33;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 32;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte textOpacityOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 34;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 33;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte shadowOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 35;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 34;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte seeThroughOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 36;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 35;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte useDefaultBackgroundOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 37;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 36;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte allighnLeftOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 38;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 37;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte allighnRightOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 39;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 38;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }

        public static byte allighnCenterOffset() {
            int protocolVersion = getApi().getPacketEvents().getServerManager().getVersion().getProtocolVersion();
            if (protocolVersion >= 764 && protocolVersion <= 767) {
                return 40;
            }
            if (protocolVersion >= 762 && protocolVersion <= 763) {
                return 39;
            }
            throw new RuntimeException("Unknown protocol version for this method");
        }
    }
}

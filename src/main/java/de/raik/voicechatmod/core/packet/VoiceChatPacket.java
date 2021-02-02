package de.raik.voicechatmod.core.packet;

import com.google.gson.JsonElement;

import java.util.UUID;

/**
 * Abstract class for creating
 * a voicechat packet to send packets easily
 *
 * @author Raik
 * @version 1.0
 */
public abstract class VoiceChatPacket {

    /**
     * The uuid of the player that should receive the packet
     */
    private final UUID targetUUID;

    /**
     * Default constructor
     * setting the target
     *
     * @param target The target uuid
     */
    public VoiceChatPacket(UUID target) {
        this.targetUUID = target;
    }

    /**
     * UUID Getter
     * protected because is only needed
     * in same package
     *
     * @return The uuid
     */
    protected UUID getTargetUUID() {
        return this.targetUUID;
    }

    /**
     * Method to set the key
     * in a packet type
     *
     * @return The key name
     */
    public abstract String getKey();

    /**
     * Method to receive the packet data
     * will be set by the different packets
     *
     * @return The content
     */
    public abstract JsonElement getPacketContent();

}

package de.raik.voicechatmod.core.implementation.packet;

import com.google.gson.JsonElement;

import java.util.UUID;

/**
 * Super class representing the communication
 * way for plugin and client
 * Will contain plugin sending and receiving
 * Will spread received packets to handling
 *
 * @author Raik
 * @version 1.0
 */
public abstract class PacketTransmitter {

    /**
     * Field representing the
     * plugin channel to handle
     */
    public static final String CHANNEL = "LMC";

    /**
     * Adding packet dispatcher to tranmit packets to handling
     */
    private final PacketDispatcher packetDispatcher;

    /**
     * Constructor for setting variables
     *
     * @param packetDispatcher The command dispatcher to set
     */
    public PacketTransmitter(PacketDispatcher packetDispatcher) {
        this.packetDispatcher = packetDispatcher;
    }

    /**
     * Sends the packet to the target uuid
     * using the implementation of the sub project
     *
     * @param target The uuid of the player who should receive the packet
     * @param key The key of the message
     * @param packetContent The content of packet to send
     */
    public abstract void sendPacket(UUID target, String key, JsonElement packetContent);

    /**
     * Method called by the transmitter
     * to port the packet to the transmitter
     *
     * @param sender The packet sender
     * @param packetContent The content of the packet
     */
    public void receivePacket(UUID sender, String key, JsonElement packetContent) {
        this.packetDispatcher.handleIncomingPacket(sender, key, packetContent);
    }

}

package de.raik.voicechatmod.core.packet;

import com.google.gson.JsonElement;
import de.raik.voicechatmod.core.plugin.PluginImplementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

/**
 * Class to store and handling
 * plugin messages and their listeners
 *
 * @author Raik
 * @version 1.0
 */
public class PacketDispatcher {

    /**
     * HashMap saving every listener regarding to the LabyMod lmc key
     */
    private final HashMap<String, HashSet<PacketListener>> keyListeners = new HashMap<>();

    /**
     * Packet transmitter to send some packets to the client
     */
    private final PacketTransmitter packetTransmitter;

    /**
     * Constructor creating
     * the transmitter using the sub implementation
     *
     * @param pluginBootstrap The plugin implementation
     */
    public PacketDispatcher(PluginImplementation pluginBootstrap) {
        this.packetTransmitter = pluginBootstrap.getPacketTransmitter(this);
    }

    /**
     * Register methods to the HashMap
     * so they can get called
     *
     * @param key The key of plugin messages to listener will lsiten to
     * @param listener The listener
     */
    public void registerListener(String key, PacketListener listener) {
        key = key.toLowerCase();

        //Add new key in HashMap if not exist
        if (!this.keyListeners.containsKey(key)) {
            this.keyListeners.put(key, new HashSet<>());
        }

        this.keyListeners.get(key).add(listener);
    }

    /**
     * Method to send a packet using the transmitter
     *
     * @param packetToSend The packet to send
     */
    public void sendPacket(VoiceChatPacket packetToSend) {
        this.packetTransmitter.sendPacket(packetToSend.getTargetUUID(), packetToSend.getKey(), packetToSend.getPacketContent());
    }

    /**
     * Handling method to call every key listener
     * called by the PacketTransmitter
     *
     * @param sender The packet sender
     * @param key The key of the lmc packet
     * @param packetContent the content of the packet
     */
    protected void handleIncomingPacket(UUID sender, String key, JsonElement packetContent) {
        this.keyListeners.get(key.toLowerCase()).forEach(listener -> listener.onReceive(sender, packetContent));
    }

}

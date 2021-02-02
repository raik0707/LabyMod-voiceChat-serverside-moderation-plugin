package de.raik.voicechatmod.core.plugin;

import de.raik.voicechatmod.core.packet.PacketDispatcher;
import de.raik.voicechatmod.core.packet.PacketTransmitter;

/**
 * Implementation collection for
 * implementing plugin to the platforms
 *
 * @author Raik
 * @version 1.0
 */
public interface PluginImplementation {

    /**
     * Getter for the packet transmitter
     * set by the implementation
     *
     * @param dispatcher The command dispatcher to create
     * @return The transmitter
     */
    PacketTransmitter getPacketTransmitter(PacketDispatcher dispatcher);

}

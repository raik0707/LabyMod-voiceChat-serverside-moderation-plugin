package de.raik.voicechatmod.core.plugin;

import de.raik.voicechatmod.core.implementation.join.JoinEventCaller;
import de.raik.voicechatmod.core.implementation.packet.PacketDispatcher;
import de.raik.voicechatmod.core.implementation.packet.PacketTransmitter;

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

    /**
     * Setting up the the join converter for the server
     * software
     *
     * @param caller The join event caller for setting up transmitting
     */
    void setupJoinConverter(JoinEventCaller caller);

}

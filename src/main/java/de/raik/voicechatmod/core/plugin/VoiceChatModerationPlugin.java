package de.raik.voicechatmod.core.plugin;

import de.raik.voicechatmod.core.join.JoinEventCaller;
import de.raik.voicechatmod.core.packet.PacketDispatcher;

/**
 * Plugin instance for controlling
 * the plugin
 *
 * @author Raik
 * @version 1.0
 */

public class VoiceChatModerationPlugin {

    /**
     * The bootstrap to connect with the plugin
     */
    private final PluginImplementation pluginBoostrap;

    /**
     * Handler for packets
     */
    private final PacketDispatcher packetDispatcher;

    /**
     * Join event caller for handling joins to the server
     */
    private final JoinEventCaller joinEventCaller = new JoinEventCaller();

    /**
     * Constructor for creating the plugin
     *
     * @param pluginBoostrap The plugin bootstrap for connection
     */
    public VoiceChatModerationPlugin(PluginImplementation pluginBoostrap) {
        this.pluginBoostrap = pluginBoostrap;

        this.packetDispatcher = new PacketDispatcher(pluginBoostrap);
        pluginBoostrap.setupJoinConverter(this.joinEventCaller);
    }
}

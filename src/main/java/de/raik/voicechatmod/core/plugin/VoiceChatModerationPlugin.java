package de.raik.voicechatmod.core.plugin;

import de.raik.voicechatmod.core.implementation.Config;
import de.raik.voicechatmod.core.implementation.Scheduler;
import de.raik.voicechatmod.core.implementation.join.JoinEventCaller;
import de.raik.voicechatmod.core.implementation.packet.PacketDispatcher;
import de.raik.voicechatmod.core.implementation.user.User;
import de.raik.voicechatmod.core.implementation.user.UserProvider;

import java.util.HashSet;
import java.util.UUID;

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
     * The config of the plugin
     */
    private final Config config;

    /**
     * The user provider to get the config
     */
    private final UserProvider userProvider;

    /**
     * Scheduler to execute tasks later or repeating
     */
    private final Scheduler scheduler;

    /**
     * A hashset representing every voicechat user
     */
    private final HashSet<User> voiceUsers = new HashSet<>();

    /**
     * Constructor for creating the plugin
     *
     * @param pluginBoostrap The plugin bootstrap for connection
     */
    public VoiceChatModerationPlugin(PluginImplementation pluginBoostrap) {
        this.pluginBoostrap = pluginBoostrap;

        //Calling bootstrap methods to set anything up
        this.packetDispatcher = new PacketDispatcher(pluginBoostrap);
        pluginBoostrap.setupJoinConverter(this.joinEventCaller);
        this.config = pluginBoostrap.getMainConfig();
        this.userProvider = pluginBoostrap.getUserProvider();
        this.scheduler = pluginBoostrap.getScheduler();
    }

    /**
     * Method to receive to user from a
     * uuid
     *
     * @param uuid The players uuid
     * @return The user
     */
    public User getUser(UUID uuid) {
        return this.userProvider.getUser(uuid);
    }
}

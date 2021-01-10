package de.raik.voicechatmod.core.plugin;

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
     * Constructor for creating the plugin
     *
     * @param pluginBoostrap The plugin bootstrap for connection
     */
    public VoiceChatModerationPlugin(PluginImplementation pluginBoostrap) {
        this.pluginBoostrap = pluginBoostrap;
    }
}

package de.raik.voicechatmod.spigot.config;

import de.raik.voicechatmod.core.implementation.Config;
import de.raik.voicechatmod.spigot.SpigotVoiceChatPlugin;

/**
 * Spigot config implementation for
 * the main plugin
 *
 * @author Raik
 * @version 1.0
 */
public class SpigotConfig implements Config {

    /**
     * Spigot plugin instance for managing and
     * accessing the configs
     */
    private final SpigotVoiceChatPlugin spigotPlugin;

    /**
     * Constructor setting variables
     * Setting the plugin
     * and saving the config
     *
     * @param plugin The plugin to set
     */
    public SpigotConfig(SpigotVoiceChatPlugin plugin) {
        this.spigotPlugin = plugin;
        //Saving default values
        plugin.saveDefaultConfig();
    }

    /**
     * Method to set values of the config
     *
     * @param path     The path of the config value
     * @param newValue The value of the config to set
     */
    @Override
    public void set(String path, Object newValue) {
        this.spigotPlugin.getConfig().set(path, newValue);
        //Automatically saving config after editing
        this.spigotPlugin.saveConfig();
    }

    /**
     * Method to get a config value as boolean
     *
     * @param path The config path
     * @return The boolean value
     */
    @Override
    public boolean getBoolean(String path) {
        return this.spigotPlugin.getConfig().getBoolean(path);
    }

    /**
     * Method to get a config value as int
     *
     * @param path The config path
     * @return The int value
     */
    @Override
    public int getInt(String path) {
        return this.spigotPlugin.getConfig().getInt(path);
    }

    /**
     * Method to get a config value as String
     *
     * @param path The config path
     * @return The String config value
     */
    @Override
    public String getString(String path) {
        return this.spigotPlugin.getConfig().getString(path);
    }
}

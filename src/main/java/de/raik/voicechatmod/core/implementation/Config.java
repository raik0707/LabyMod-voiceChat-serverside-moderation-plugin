package de.raik.voicechatmod.core.implementation;

/**
 * Interface representing the config
 * of the plugin used by sub modules
 * to create config interaction
 *
 * @author Raik
 * @version 1.0
 */
public interface Config {

    /**
     * Method to set values of the config
     *
     * @param path The path of the config value
     * @param newValue The value of the config to set
     */
    void set(String path, Object newValue);

    /**
     * Method to get a config value as boolean
     *
     * @param path The config path
     * @return The boolean value
     */
    boolean getBoolean(String path);

    /**
     * Method to get a config value as int
     *
     * @param path The config path
     * @return The int value
     */
    int getInt(String path);

    /**
     * Method to get a config value as String
     *
     * @param path The config path
     * @return The String config value
     */
    String getString(String path);

}

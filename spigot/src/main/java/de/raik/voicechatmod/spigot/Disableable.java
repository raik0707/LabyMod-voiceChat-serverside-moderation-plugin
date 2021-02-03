package de.raik.voicechatmod.spigot;

/**
 * Interface representing every
 * thing than can be disabled on plugin disable
 *
 * @author Raik
 * @version 1.0
 */
public interface Disableable {

    /**
     * Method called by the plugin to disable
     * the class
     *
     * @param plugin The plugin instance which may be needed
     */
    void disable(SpigotVoiceChatPlugin plugin);

}

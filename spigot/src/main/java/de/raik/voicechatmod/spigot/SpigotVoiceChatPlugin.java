package de.raik.voicechatmod.spigot;

import de.raik.voicechatmod.core.packet.PacketDispatcher;
import de.raik.voicechatmod.core.packet.PacketTransmitter;
import de.raik.voicechatmod.core.plugin.PluginImplementation;
import de.raik.voicechatmod.core.plugin.VoiceChatModerationPlugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Plugin boostrap and plugin instance for spigot
 *
 * @author Raik
 * @version 1.0
 */
public class SpigotVoiceChatPlugin extends JavaPlugin implements PluginImplementation {

    /**
     * Plugin instance for managing access to plugin core for managing everything
     */
    private VoiceChatModerationPlugin moderationPlugin;

    /**
     * Getter for the packet transmitter
     * set by the implementation
     *
     * @param dispatcher The command dispatcher to create
     * @return The transmitter
     */
    @Override
    public PacketTransmitter getPacketTransmitter(PacketDispatcher dispatcher) {
        return null;
    }
}

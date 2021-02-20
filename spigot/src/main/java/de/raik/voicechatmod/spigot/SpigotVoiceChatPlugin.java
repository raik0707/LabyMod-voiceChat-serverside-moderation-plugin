package de.raik.voicechatmod.spigot;

import de.raik.voicechatmod.core.packet.PacketDispatcher;
import de.raik.voicechatmod.core.packet.PacketTransmitter;
import de.raik.voicechatmod.core.plugin.PluginImplementation;
import de.raik.voicechatmod.core.plugin.VoiceChatModerationPlugin;
import de.raik.voicechatmod.spigot.packet.SpigotPacketTransmitter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;

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
     * Collection of every thing that can be disabled to mass disable it
     */
    private final HashSet<Disableable> thingsNeedingToDisable = new HashSet<>();

    /**
     * Getter for the packet transmitter
     * set by the implementation
     *
     * @param dispatcher The command dispatcher to create
     * @return The transmitter
     */
    @Override
    public PacketTransmitter getPacketTransmitter(PacketDispatcher dispatcher) {
        SpigotPacketTransmitter transmitter = new SpigotPacketTransmitter(dispatcher, this);
        this.thingsNeedingToDisable.add(transmitter);
        return transmitter;
    }

    /**
     * Enabling method called by spigot
     */
    @Override
    public void onEnable() {
        //Creating default config
        this.saveDefaultConfig();
    }

    /**
     * Spigot method to disable the plugin
     */
    @Override
    public void onDisable() {
        this.thingsNeedingToDisable.forEach(disableable -> disableable.disable(this));
    }
}

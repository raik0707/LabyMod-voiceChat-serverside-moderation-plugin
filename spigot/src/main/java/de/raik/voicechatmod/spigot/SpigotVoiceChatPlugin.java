package de.raik.voicechatmod.spigot;

import de.raik.voicechatmod.core.implementation.Config;
import de.raik.voicechatmod.core.implementation.join.JoinEventCaller;
import de.raik.voicechatmod.core.implementation.packet.PacketDispatcher;
import de.raik.voicechatmod.core.implementation.packet.PacketTransmitter;
import de.raik.voicechatmod.core.plugin.PluginImplementation;
import de.raik.voicechatmod.core.plugin.VoiceChatModerationPlugin;
import de.raik.voicechatmod.spigot.config.SpigotConfig;
import de.raik.voicechatmod.spigot.join.SpigotJoinEventConverter;
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
     * Setting up the the join converter for the server
     * software
     *
     * @param caller The join event caller for setting up transmitting
     */
    @Override
    public void setupJoinConverter(JoinEventCaller caller) {
        new SpigotJoinEventConverter(caller, this);
    }

    /**
     * Getting the main config file from
     * the sub module to manage it
     *
     * @return The config
     */
    @Override
    public Config getMainConfig() {
        return new SpigotConfig(this);
    }

    /**
     * Enabling method called by spigot
     */
    @Override
    public void onEnable() {
    }

    /**
     * Spigot method to disable the plugin
     */
    @Override
    public void onDisable() {
        this.thingsNeedingToDisable.forEach(disableable -> disableable.disable(this));
    }
}

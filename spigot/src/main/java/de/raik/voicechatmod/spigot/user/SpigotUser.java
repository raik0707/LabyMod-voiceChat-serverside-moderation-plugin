package de.raik.voicechatmod.spigot.user;

import de.raik.voicechatmod.core.implementation.user.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Spigot implementation of a user
 * for the voice chat plugin
 *
 * @author Raik
 * @version 1.0
 */
public class SpigotUser implements User {

    /**
     * The spigot player being equal to the user
     */
    private final Player player;

    /**
     * Constructor receiving the player from the uuid
     * using the Bukkit class to get
     * Protected - Should only be accessible
     *
     * @param uuid The players uuid
     */
    protected SpigotUser(UUID uuid) {
        this.player = Bukkit.getPlayer(uuid);
    }

    /**
     * Method to kick the user from
     * the server
     *
     * @param reason The reason of the kick
     */
    @Override
    public void kick(String reason) {
        this.player.kickPlayer(reason);
    }

    /**
     * Method to send a message to a user
     *
     * @param message The message to send
     */
    @Override
    public void message(String message) {
        this.player.sendMessage(message);
    }
}

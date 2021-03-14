package de.raik.voicechatmod.spigot.user;

import de.raik.voicechatmod.core.implementation.user.User;
import de.raik.voicechatmod.core.implementation.user.UserProvider;

import java.util.UUID;

/**
 * Spigot implementation for providing a user
 * to the plugin
 *
 * @author Raik
 * @version 1.0
 */
public class SpigotUserProvider implements UserProvider {

    /**
     * Method to get a user from the uuid
     *
     * @param uuid The players uuid
     * @return The user instance
     */
    @Override
    public User getUser(UUID uuid) {
        //Using spigot user
        return new SpigotUser(uuid);
    }
}

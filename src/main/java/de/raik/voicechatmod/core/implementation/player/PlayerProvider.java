package de.raik.voicechatmod.core.implementation.player;

import java.util.UUID;

/**
 * Instance providing a player
 * from the implementation
 *
 * @author Raik
 * @version 1.0
 */
public interface PlayerProvider {

    /**
     * Method to get a player from the uuid
     *
     * @param uuid The players uuid
     * @return The player instance
     */
    Player getPlayer(UUID uuid);

}

package de.raik.voicechatmod.core.implementation.player;

/**
 * Interface representing a player instance
 * for manipulate or handle a player
 *
 * @author Raik
 * @version 1.0
 */
public interface Player {

    /**
     * Method to kick the player from
     * the server
     *
     * @param reason The reason of the kick
     */
    void kick(String reason);

    /**
     * Method to send a message to a player
     *
     * @param message The message to send
     */
    void message(String message);

}

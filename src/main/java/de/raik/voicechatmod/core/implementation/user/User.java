package de.raik.voicechatmod.core.implementation.user;

/**
 * Interface representing a player instance
 * for manipulate or handle a user
 *
 * @author Raik
 * @version 1.0
 */
public interface User {

    /**
     * Method to kick the user from
     * the server
     *
     * @param reason The reason of the kick
     */
    void kick(String reason);

    /**
     * Method to send a message to a user
     *
     * @param message The message to send
     */
    void message(String message);

}

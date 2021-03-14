package de.raik.voicechatmod.core.implementation.user;

import java.util.UUID;

/**
 * Instance providing a user
 * from the implementation
 *
 * @author Raik
 * @version 1.0
 */
public interface UserProvider {

    /**
     * Method to get a user from the uuid
     *
     * @param uuid The players uuid
     * @return The user instance
     */
    User getUser(UUID uuid);

}

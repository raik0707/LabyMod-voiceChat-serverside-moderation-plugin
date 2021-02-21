package de.raik.voicechatmod.core.implementation.join;

import java.util.UUID;

/**
 * Listener interface to interact
 * with join packets.
 *
 * @author Raik
 * @version 1.0
 */
public interface JoinListener {

    /**
     * Interface method to overwrite
     * called on event call
     *
     * @param playerUUID The joining player
     * @param joinType The type of the join
     */
    void onJoin(UUID playerUUID, JoinType joinType);

}

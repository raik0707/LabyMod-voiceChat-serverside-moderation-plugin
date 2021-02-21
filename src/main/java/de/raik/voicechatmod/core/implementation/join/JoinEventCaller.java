package de.raik.voicechatmod.core.implementation.join;

import java.util.HashMap;
import java.util.HashSet;
import java.util.UUID;

/**
 * Class storing handling and managing the join events
 * of the sub projects
 *
 * @author Raik
 * @version 1.0
 */
public class JoinEventCaller {

    /**
     * Storing place for the listeners
     */
    private final HashMap<JoinType, HashSet<JoinListener>> joinListenerMap = new HashMap<>();

    /**
     * Registering listener for calling
     * for event calling
     *
     * @param joinType The join type of the event
     * @param listener The listener
     */
    public void registerListener(JoinType joinType, JoinListener listener) {
        //Adding new key in HashMap if not present
        if (!this.joinListenerMap.containsKey(joinType)) {
            this.joinListenerMap.put(joinType, new HashSet<>());
        }

        this.joinListenerMap.get(joinType).add(listener);
    }

    /**
     * Registering a listener to every join type
     * for a all around managing
     *
     * @param listener The listner
     */
    public void registerListener(JoinListener listener) {
        //Going through every join type to register the listener each
        for (JoinType joinType: JoinType.values()) {
            //Calling inner method for dynamic handling
            this.registerListener(joinType, listener);
        }
    }

    /**
     * Handling incoming joins
     * protected because of called by event converter
     *
     * @param joiningPlayer The uuuid of the joining player
     * @param joinType The join type of the event
     */
    protected void handleIncomingJoins(UUID joiningPlayer, JoinType joinType) {
        this.joinListenerMap.get(joinType).forEach(listener -> listener.onJoin(joiningPlayer, joinType));
    }

}

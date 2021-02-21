package de.raik.voicechatmod.core.implementation.join;

import java.util.UUID;

/**
 * Communicating super class for
 * converting the join event to the main project
 * contains event receiving
 *
 * @author Raik
 * @version 1.0
 */
public abstract class JoinEventConverter {

    /**
     * Join event caller to dispatch packets to the plugin
     * and event managing
     */
    private final JoinEventCaller joinEventCaller;

    /**
     * Constructor for setting the event caller
     *
     * @param joinEventCaller The event caller for dispatching the packet
     */
    public JoinEventConverter(JoinEventCaller joinEventCaller) {
        this.joinEventCaller = joinEventCaller;
    }

    /**
     * Method called by the converter
     * to port joining to plugin
     *
     * @param joiningPlayer The joining player
     * @param joinType the join type
     */
    public void convertJoin(UUID joiningPlayer, JoinType joinType) {
        this.joinEventCaller.handleIncomingJoins(joiningPlayer, joinType);
    }

}

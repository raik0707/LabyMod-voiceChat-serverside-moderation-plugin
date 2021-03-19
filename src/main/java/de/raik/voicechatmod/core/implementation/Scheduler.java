package de.raik.voicechatmod.core.implementation;

/**
 * Interface to implement the
 * running of tasks later or repeating
 * by the sever software
 *
 * @author Raik
 * @version 1.0
 */
public interface Scheduler {

    /**
     * Method to cancel a running task
     * with it's id
     *
     * @param id The tasks id
     */
    void cancel(int id);

    /**
     * Method to run a task in the servers
     * scheduler once
     *
     * @param runnableToExecute The code which will be executed by the server
     * @param delay The delay in ticks before the task will run
     * @return The tasks id
     */
    int run(Runnable runnableToExecute, int delay);

    /**
     * Method to run a task which repeats in a
     * specific delay in the servers scheduler
     * until it gets canceled
     *
     * @param runnableToExecute The code to execute
     * @param startDelay The delay until it will run the first time
     * @param repeatingDelay The delay between the executions of the code
     * @return The tasks id
     */
    int runRepeating(Runnable runnableToExecute, int startDelay, int repeatingDelay);

}

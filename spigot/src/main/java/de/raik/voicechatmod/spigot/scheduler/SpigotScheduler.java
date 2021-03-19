package de.raik.voicechatmod.spigot.scheduler;

import de.raik.voicechatmod.core.implementation.Scheduler;
import de.raik.voicechatmod.spigot.SpigotVoiceChatPlugin;
import org.bukkit.Bukkit;

/**
 * Spigot implementation of the scheduler
 * using the bukkit Scheduler
 *
 * @author Raik
 * @version 1.0
 */
public class SpigotScheduler implements Scheduler {

    /**
     * Spigot plugin to use it when creating a task
     */
    private final SpigotVoiceChatPlugin spigotPlugin;

    /**
     * Constructor to set the default plugin
     *
     * @param spigotPlugin The plugin instance
     */
    public SpigotScheduler(SpigotVoiceChatPlugin spigotPlugin) {
        this.spigotPlugin = spigotPlugin;
    }

    /**
     * Method to cancel a running task
     * with it's id
     *
     * @param id The tasks id
     */
    @Override
    public void cancel(int id) {
        Bukkit.getScheduler().cancelTask(id);
    }

    /**
     * Method to run a task in the servers
     * scheduler once
     *
     * @param runnableToExecute The code which will be executed by the server
     * @param delay             The delay in ticks before the task will run
     * @return The tasks id
     */
    @Override
    public int run(Runnable runnableToExecute, int delay) {
        return Bukkit.getScheduler().scheduleSyncDelayedTask(this.spigotPlugin, runnableToExecute, delay);
    }

    /**
     * Method to run a task which repeats in a
     * specific delay in the servers scheduler
     * until it gets canceled
     *
     * @param runnableToExecute The code to execute
     * @param startDelay        The delay until it will run the first time
     * @param repeatingDelay    The delay between the executions of the code
     * @return The tasks id
     */
    @Override
    public int runRepeating(Runnable runnableToExecute, int startDelay, int repeatingDelay) {
        return Bukkit.getScheduler().scheduleSyncRepeatingTask(this.spigotPlugin, runnableToExecute, startDelay
                , repeatingDelay);
    }
}

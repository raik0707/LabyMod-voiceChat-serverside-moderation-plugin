package de.raik.voicechatmod.spigot.join;

import de.raik.voicechatmod.core.implementation.join.JoinEventCaller;
import de.raik.voicechatmod.core.implementation.join.JoinEventConverter;
import de.raik.voicechatmod.core.implementation.join.JoinType;
import de.raik.voicechatmod.spigot.SpigotVoiceChatPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Implementation for spigot to use
 * join events in plugin
 * for tracking players actions
 *
 * @author Raik
 * @version 1.0
 */
public class SpigotJoinEventConverter extends JoinEventConverter implements Listener {

    /**
     * Constructor for setting the event caller
     *
     * @param joinEventCaller The event caller for dispatching the packet
     * @param spigotPlugin Spigot plugin to register listener
     */
    public SpigotJoinEventConverter(JoinEventCaller joinEventCaller, SpigotVoiceChatPlugin spigotPlugin) {
        super(joinEventCaller);

        //Registering listener
        Bukkit.getPluginManager().registerEvents(this, spigotPlugin);
    }

    /**
     * On join event calling of spigot
     * using annotation for register event
     *
     * @param joinEvent The join event
     */
    @EventHandler
    public void onJoin(PlayerJoinEvent joinEvent) {
        this.convertJoin(joinEvent.getPlayer().getUniqueId(), JoinType.JOIN);
    }

    /**
     * On login event calling of spigot
     * to handle login attempts
     * using annotation for register event
     *
     * @param loginEvent The join event
     */
    @EventHandler
    public void onLogin(PlayerLoginEvent loginEvent) {
        this.convertJoin(loginEvent.getPlayer().getUniqueId(), JoinType.LOGIN);
    }

}

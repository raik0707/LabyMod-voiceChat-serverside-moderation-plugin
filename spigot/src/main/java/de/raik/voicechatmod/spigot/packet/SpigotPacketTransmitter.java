package de.raik.voicechatmod.spigot.packet;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import de.raik.voicechatmod.core.implementation.packet.PacketDispatcher;
import de.raik.voicechatmod.core.implementation.packet.PacketTransmitter;
import de.raik.voicechatmod.spigot.Disableable;
import de.raik.voicechatmod.spigot.SpigotVoiceChatPlugin;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.server.v1_8_R3.PacketDataSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutCustomPayload;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.UUID;

/**
 * Implementation for spigot
 * to use the packet sending
 * Using plugin message listener
 * to track plugin messages
 * Can be disabled to shoutdown Plugin channel listening
 *
 * @author Raik
 * @version 1.0
 */
public class SpigotPacketTransmitter extends PacketTransmitter implements PluginMessageListener, Disableable {

    /**
     * Json parser to parse strings to json element
     */
    private static final JsonParser JSON_PARSER = new JsonParser();

    /**
     * Constructor for setting variables
     * Registering itself for listening
     *
     * @param packetDispatcher The command dispatcher to set
     * @param spigotPlugin Spigot plugin for registering listener
     */
    public SpigotPacketTransmitter(PacketDispatcher packetDispatcher, SpigotVoiceChatPlugin spigotPlugin) {
        super(packetDispatcher);

        //Registering plugin listening
        spigotPlugin.getServer().getMessenger().registerIncomingPluginChannel(spigotPlugin, CHANNEL, this);
    }

    /**
     * Sends the packet to the target uuid
     * using the implementation of the sub project
     *
     * @param target        The uuid of the player who should receive the packet
     * @param key           The key of the message
     * @param packetContent The content of packet to send
     */
    @Override
    public void sendPacket(UUID target, String key, JsonElement packetContent) {
        PacketDataSerializer packetDataSerializer = new PacketDataSerializer(PacketUtils.getBytesToSend(key, packetContent.toString()));
        PacketPlayOutCustomPayload payload = new PacketPlayOutCustomPayload(CHANNEL, packetDataSerializer);
        ((CraftPlayer) Bukkit.getPlayer(target)).getHandle().playerConnection.sendPacket(payload);
    }

    /**
     * Method called by spigot on plugin message for the selected channel
     *
     * @param channel The channel name
     * @param player The sender
     * @param data The packet data in bytes
     */
    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] data) {
        ByteBuf buf = Unpooled.wrappedBuffer(data);

        //Parsing the data from the bytes
        String key = PacketUtils.readString(buf, Short.MAX_VALUE);
        JsonElement content = JSON_PARSER.parse(PacketUtils.readString(buf, Short.MAX_VALUE));

        //Call the packet receiving to the plugin
        this.receivePacket(player.getUniqueId(), key, content);
    }

    /**
     * Method called by the plugin to disable
     * the class
     * Disabled plugin channel listening
     *
     * @param plugin The plugin instance which may be needed
     */
    @Override
    public void disable(SpigotVoiceChatPlugin plugin) {
        plugin.getServer().getMessenger().unregisterIncomingPluginChannel(plugin, CHANNEL);
    }
}

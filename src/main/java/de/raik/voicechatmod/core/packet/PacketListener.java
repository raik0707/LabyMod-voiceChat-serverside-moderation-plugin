package de.raik.voicechatmod.core.packet;

import com.google.gson.JsonElement;

import java.util.UUID;

/**
 * Listener interface to
 * get packet Json Object
 * which listend to
 *
 * @author Raik
 * @version 1.0
 */
public interface PacketListener {

    /**
     * Method called on packet receiving
     *
     * @param sender The packet sender
     * @param packetContent The content of the packet
     */
    void onReceive(UUID sender, JsonElement packetContent);

}

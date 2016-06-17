package org.cakepowered.mod.util;

import org.cakepowered.api.title.Title;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.server.S45PacketTitle;
import net.minecraft.network.play.server.S45PacketTitle.Type;
import net.minecraft.util.ChatComponentText;

public class TitleUtils {

	public static void sendTitle(NetHandlerPlayServer net, EntityPlayer player, Title t) {

		if (t.isReset()) {
			S45PacketTitle p = new S45PacketTitle(S45PacketTitle.Type.RESET, null);
			net.sendPacket(p);
		} else {
			S45PacketTitle p = null;
			if (t.getTitle() != null) {
				p = new S45PacketTitle(Type.TITLE, new ChatComponentText(t.getTitle()), t.getStartTime(),
						t.getShowTime(), t.getEndTime());
				net.sendPacket(p);
			} else {
				p = new S45PacketTitle(Type.TITLE, null);
				net.sendPacket(p);
			}
			if (t.getSubTitle() != null) {
				p = new S45PacketTitle(Type.SUBTITLE, new ChatComponentText(t.getSubTitle()), t.getStartTime(),
						t.getShowTime(), t.getEndTime());
				net.sendPacket(p);
			}

			p = new S45PacketTitle(Type.TIMES, null, t.getStartTime(), t.getShowTime(), t.getEndTime());
			net.sendPacket(p);
		}
	}
}

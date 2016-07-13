package org.cakepowered.mod.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.server.SPacketTitle;
import net.minecraft.network.play.server.SPacketTitle.Type;
import net.minecraft.util.text.TextComponentString;
import org.cakepowered.api.title.Title;

public class TitleUtils {

	public static void sendTitle(NetHandlerPlayServer net, EntityPlayer player, Title t) {

		if (t.isReset()) {
			SPacketTitle p = new SPacketTitle(SPacketTitle.Type.RESET, null);
			net.sendPacket(p);
		} else {
			SPacketTitle p = null;
			if (t.getTitle() != null) {
				p = new SPacketTitle(Type.TITLE, new TextComponentString(t.getTitle()), t.getStartTime(),
						t.getShowTime(), t.getEndTime());
				net.sendPacket(p);
			} else {
				p = new SPacketTitle(Type.TITLE, null);
				net.sendPacket(p);
			}
			if (t.getSubTitle() != null) {
				p = new SPacketTitle(Type.SUBTITLE, new TextComponentString(t.getSubTitle()), t.getStartTime(),
						t.getShowTime(), t.getEndTime());
				net.sendPacket(p);
			}

			p = new SPacketTitle(Type.TIMES, null, t.getStartTime(), t.getShowTime(), t.getEndTime());
			net.sendPacket(p);
		}
	}
}

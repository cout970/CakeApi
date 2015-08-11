package org.cakepowered.api;

import java.util.Map;

import org.cakepowered.api.base.Log;
import org.cakepowered.api.util.Ref;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;

public class CakeCoremod implements IFMLLoadingPlugin{

	@Override
	public String[] getASMTransformerClass() {
		return null;
	}

	@Override
	public String getModContainerClass() {
		return "org.cakepowered.api.CakeApiMod";
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}
}

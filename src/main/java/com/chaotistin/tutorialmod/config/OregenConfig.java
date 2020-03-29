package com.chaotistin.tutorialmod.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig 
{
	public static ForgeConfigSpec.IntValue flux_chance;
	public static ForgeConfigSpec.BooleanValue generate_overworld;
	
	public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client)
	{
		server.comment("Oregen Config");
		
		flux_chance = server
				.comment("Maximum number of ore veins of the tutorial ore that can spawn in one chunk.")
				.defineInRange("oregen.flux_chance", 20, 1, 1000000);
		
		generate_overworld = server
				.comment("Decide if you want Tutorial Mod ores to spawn in the overworld")
				.define("oregen.generate_overworld", true);
	}
}

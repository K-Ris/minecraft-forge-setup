package com.chaotistin.tutorialmod.world;

import com.chaotistin.tutorialmod.config.OregenConfig;
import com.chaotistin.tutorialmod.lists.BlockList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration
{
	public static void setupOreGeneration()
	{
		for (Biome biome : ForgeRegistries.BIOMES)
		{
			CountRangeConfig flux_ore_placement = new CountRangeConfig(1000, 20, 20, 100);
			biome.addFeature(Decoration.UNDERGROUND_ORES,
					new ConfiguredFeature<OreFeatureConfig>(Feature.ORE,
							new OreFeatureConfig(FillerBlockType.NATURAL_STONE, BlockList.flux_ore.getDefaultState(),
									OregenConfig.flux_chance.get())));
		}

		// Biome biome = Biomes.BEACH;
		// biome.addFeature(decorationStage, featureIn);
	}
}

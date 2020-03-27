package com.chaotistin.tutorialmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaotistin.tutorialmod.lists.BlockList;
import com.chaotistin.tutorialmod.lists.ItemList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("tutorialmod")
public class Main
{
	public static Main instance;
	public static final String modid = "tutorialmod";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public Main()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("ClientRegistries method registered");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event)
		{
			event.getRegistry().registerAll
			(
					ItemList.tutorial_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("tutorial_item")),
					
					
					ItemList.tutorial_block = new BlockItem(BlockList.tutorial_block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(BlockList.tutorial_block.getRegistryName())
			);
			
			logger.info("Items registered");
		}
		
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event)
		{
			event.getRegistry().registerAll(
					BlockList.tutorial_block = new Block(Block.Properties
						.create(Material.IRON)
						.hardnessAndResistance(2.0f, 3.0f)
						.lightValue(4)
						.sound(SoundType.SLIME))
						.setRegistryName("tutorial_block")
			);
			
			logger.info("Items registered");
		}
		
		private static ResourceLocation location(String name)
		{
			return new ResourceLocation(modid, name);
		}
	}
}

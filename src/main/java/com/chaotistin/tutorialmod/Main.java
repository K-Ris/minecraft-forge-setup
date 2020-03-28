package com.chaotistin.tutorialmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.chaotistin.tutorialmod.lists.BlockList;
import com.chaotistin.tutorialmod.lists.ItemList;
import com.chaotistin.tutorialmod.lists.ToolMaterialList;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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
	
	public static final ItemGroup tutorial = new TutorialItemGroup();
	
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
					ItemList.tutorial_item = new Item(new Item.Properties().group(tutorial)).setRegistryName(location("tutorial_item")),
					
					ItemList.tutorial_item = new Item(new Item.Properties().group(tutorial)).setRegistryName(location("steel_ingot")),
					
					ItemList.steel_axe = new AxeItem(ToolMaterialList.steel, -1.0f, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("steel_axe")),
					ItemList.steel_pickaxe = new PickaxeItem(ToolMaterialList.steel, -1, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("steel_pickaxe")),
					ItemList.steel_hoe = new HoeItem(ToolMaterialList.steel, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("steel_hoe")),
					ItemList.steel_axe = new ShovelItem(ToolMaterialList.steel, -1.0f, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("steel_shovel")),
					ItemList.steel_axe = new SwordItem(ToolMaterialList.steel, 0, 6.0f, new Item.Properties().group(tutorial)).setRegistryName(location("steel_sword")),
					
					ItemList.tutorial_block = new BlockItem(BlockList.tutorial_block, new Item.Properties().group(tutorial)).setRegistryName(BlockList.tutorial_block.getRegistryName())
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

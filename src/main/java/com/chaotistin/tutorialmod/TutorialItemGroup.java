package com.chaotistin.tutorialmod;

import com.chaotistin.tutorialmod.lists.BlockList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class TutorialItemGroup extends ItemGroup{

	public TutorialItemGroup()
	{
		super("tutorial");
		
	}

	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(Item.BLOCK_TO_ITEM.get(BlockList.tutorial_block));
	}
	
}

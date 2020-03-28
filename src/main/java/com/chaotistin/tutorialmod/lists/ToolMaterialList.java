package com.chaotistin.tutorialmod.lists;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier
{
	steel(8.0f, 9.0f, 400, 3, 25, ItemList.tutorial_item);
	
	private float attackDamage, efficiency;
	private int durability, harvestLevel, enchantability;
	private Item repairMaterial;
	
	private ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantablility, Item repairMaterial)
	{
		this.attackDamage = attackDamage;
		this.efficiency = efficiency;
		this.durability = durability;
		this.harvestLevel = harvestLevel;
		this.enchantability = enchantablility;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses()
	{
		// TODO Auto-generated method stub
		return durability;
	}

	@Override
	public float getEfficiency()
	{
		// TODO Auto-generated method stub
		return efficiency;
	}

	@Override
	public float getAttackDamage()
	{
		// TODO Auto-generated method stub
		return attackDamage;
	}

	@Override
	public int getHarvestLevel()
	{
		// TODO Auto-generated method stub
		return harvestLevel;
	}

	@Override
	public int getEnchantability()
	{
		// TODO Auto-generated method stub
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		// TODO Auto-generated method stub
		return Ingredient.fromItems(this.repairMaterial);
	}
}

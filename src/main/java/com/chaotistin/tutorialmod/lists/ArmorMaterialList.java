package com.chaotistin.tutorialmod.lists;

import com.chaotistin.tutorialmod.Main;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmorMaterialList implements IArmorMaterial
{
	tutorial("steel", 400, new int[] {8, 10, 9, 7}, 25, ItemList.tutorial_item, "item.armor.equip_chain", 0.0f);
	
	private static final int[] max_damage_array = new int[] {13,15,16,11};
	private String name, equipSound;
	private int durability, enchantablility;
	private Item repairItem;
	private int[] damageReductionAmount;
	private float toughness;
	
	private ArmorMaterialList(String name, int durability, int[] damageReductionAmount, int enchantability, Item repairItem, String equipsound, float toughness)
	{
		this.name = name;
		this.equipSound = equipsound;
		this.durability = durability;
		this.repairItem = repairItem;
		this.damageReductionAmount = damageReductionAmount;
		this.enchantablility = enchantability;
		this.toughness = toughness;
	}

	@Override
	public int getDurability(EquipmentSlotType slotIn)
	{
		// TODO Auto-generated method stub
		return this.damageReductionAmount[slotIn.getIndex()];
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn)
	{
		// TODO Auto-generated method stub
		return max_damage_array[slotIn.getIndex()] * this.durability;
	}

	@Override
	public int getEnchantability()
	{
		// TODO Auto-generated method stub
		return this.enchantablility;
	}

	@Override
	public SoundEvent getSoundEvent()
	{
		// TODO Auto-generated method stub
		return new SoundEvent(new ResourceLocation(equipSound));
	}

	@Override
	public Ingredient getRepairMaterial()
	{
		// TODO Auto-generated method stub
		return Ingredient.fromItems(this.repairItem);
	}

	@Override
	public String getName()
	{
		return Main.modid + ":" + this.name;
	}

	@Override
	public float getToughness()
	{
		// TODO Auto-generated method stub
		return this.toughness;
	}
	
}

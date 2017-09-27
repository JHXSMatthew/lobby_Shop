package com.mcndsj.lobbyShop.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {
	
	
	  public static ItemStack create(Material material, byte data, String displayName, String... lore) {
	        ItemStack itemStack = new MaterialData(material, data).toItemStack(1);
	        ItemMeta itemMeta = itemStack.getItemMeta();
	        itemMeta.setDisplayName(displayName);
	        if (lore != null) {
	            List<String> finalLore = new ArrayList<>();
	            for (String s : lore)
	                if (s != null)
	                    finalLore.add(ChatColor.GRAY + s.replace("&", String.valueOf(ChatColor.COLOR_CHAR)));
	            itemMeta.setLore( finalLore);
	        }
	        itemStack.setItemMeta(itemMeta);
	        return itemStack;
	    }


	public static ItemStack createLobbyVIPItem(Material material, byte data, String displayName, String... lore) {
		ItemStack itemStack = new MaterialData(material, data).toItemStack(1);
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(displayName);
		if (lore != null) {
			List<String> finalLore = new ArrayList<>();
			for (String s : lore)
				if (s != null)
					finalLore.add(ChatColor.GRAY + s.replace("&", String.valueOf(ChatColor.COLOR_CHAR)));
			finalLore.add(" ");
			finalLore.add(ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString()+ "✚ 永久会员-LifeTime ✚");
			itemMeta.setLore( finalLore);
		}
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

}

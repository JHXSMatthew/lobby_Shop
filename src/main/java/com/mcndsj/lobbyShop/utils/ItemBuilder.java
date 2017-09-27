package com.mcndsj.lobbyShop.utils;

import com.avaje.ebean.validation.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Matthew on 10/07/2016.
 */
public class ItemBuilder {

    private String name;
    private List<String> lore;
    private int amount = 1;
    private Material material;
    private byte data = 0;
    private HashMap<Enchantment,Integer> enchantmentMap;


    public ItemBuilder(String name,Material m , String ...lore){
        material = m;
        this.name = name;
        if(lore != null) appendLore(lore);
    }
    public ItemBuilder(){

    }



    public ItemBuilder setDisplayName(String dis){
        name = dis;
        return this;
    }

    @NotNull
    public ItemBuilder appendLore(String ...str){
        if(lore == null) lore = new ArrayList<>();
        for(String s : str){
            lore.add(s);
        }
        return this;
    }

    public ItemBuilder setAmount(int amount){
        this.amount = amount;
        return this;
    }

    public ItemBuilder clearLore(){
        if(lore != null) lore.clear();
        return this;
    }

    public ItemBuilder setEnchantment(Enchantment e, int i){
        if(enchantmentMap == null){
            enchantmentMap = new HashMap<>();
        }
        enchantmentMap.put(e,i);
        return this;
    }

    public ItemStack build(){
        ItemStack item = new ItemStack(material,amount,data);
        if(enchantmentMap != null){
            for(Map.Entry<Enchantment,Integer> e : enchantmentMap.entrySet())
                item.addUnsafeEnchantment(e.getKey(),e.getValue());
        }


        if(lore != null || name != null) {
            ItemMeta meta = item.getItemMeta();
            meta.setLore(lore);
            meta.setDisplayName(name);
            item.setItemMeta(meta);
        }
        return item;
    }

}

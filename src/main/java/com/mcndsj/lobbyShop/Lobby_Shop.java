package com.mcndsj.lobbyShop;

import com.mcndsj.lobbyShop.managers.ShopManager;
import com.mcndsj.lobbyShop.shops.personalInfo.PersonalInfo_Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.*;

/**
 * Created by Matthew on 4/07/2016.
 */
public class Lobby_Shop extends JavaPlugin implements Listener {


    private static Lobby_Shop instance;
    public void onEnable(){
        instance = this;
        getServer().getPluginManager().registerEvents(this,this);
    }

    public static Lobby_Shop get(){
        return instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent evt){
        ItemStack item = new ItemStack(Material.SKULL_ITEM,1,(short)3);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(evt.getPlayer().getName());
        meta.setDisplayName(ChatColor.GOLD + "个人信息-Info");
        item.setItemMeta(meta);
        evt.getPlayer().getInventory().setItem(2,item);
        evt.getPlayer().playSound(evt.getPlayer().getLocation(), Sound.CLICK,1F,1F);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent evt){
        if(evt.getAction() == Action.RIGHT_CLICK_AIR || evt.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(evt.getPlayer().getItemInHand() != null && evt.getPlayer().getItemInHand().getType() != Material.AIR && evt.getPlayer().getItemInHand().hasItemMeta() && evt.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains("个人信息")){
                ShopManager.get().openShop(evt.getPlayer(), PersonalInfo_Main.class);
            }
        }
    }


}

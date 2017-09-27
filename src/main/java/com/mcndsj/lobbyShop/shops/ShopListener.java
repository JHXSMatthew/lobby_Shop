package com.mcndsj.lobbyShop.shops;

import com.mcndsj.lobbyShop.Lobby_Shop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by Matthew on 7/07/2016.
 */
public class ShopListener implements Listener{

    private String player;
    private Shop shop;

    public ShopListener(String player, Shop shop){
        this.player = player;
        this.shop = shop;
        Lobby_Shop.get().getServer().getPluginManager().registerEvents(this,Lobby_Shop.get());
    }


    @EventHandler
    public void onClick(InventoryClickEvent evt){
        if(isPlayer(evt.getClickedInventory()))
            evt.setCancelled(true);

        if(!isInventory(evt.getClickedInventory()))
            return;

        if(evt.getCurrentItem() == null || evt.getCurrentItem().getType() == Material.AIR || !evt.getCurrentItem().hasItemMeta() || !evt.getCurrentItem().getItemMeta().hasDisplayName()){
            return;
        }

        shop.onPlayerClick(evt);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent evt){
        if(evt.getPlayer().getName().equals(player)){
            dispose();
        }
    }



    @EventHandler
    public void onClose(InventoryCloseEvent evt){
        if(isInventory(evt.getInventory()))
            dispose();
    }

    public void dispose(){
        HandlerList.unregisterAll(this);
    }



    public Player getPlayer(){
        return Bukkit.getPlayer(player);
    }

    private boolean isInventory(Inventory i){
        try{
            if (i != null&& i.getTitle() != null && i.getTitle().equals(shop.getTitle())) {
                for(HumanEntity entity : i.getViewers()){
                    if(entity instanceof Player){
                        Player p = (Player) entity;
                        if(p.getName().equals(player)){
                            return true;
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            dispose();
        }
        return false;
    }

    private boolean isPlayer(Inventory i){
        if (i != null){
            for(HumanEntity entity : i.getViewers()){
                if(entity instanceof Player){
                    Player p = (Player) entity;
                    if(p.getName().equals(player)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

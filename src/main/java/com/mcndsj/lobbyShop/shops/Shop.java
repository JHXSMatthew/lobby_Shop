package com.mcndsj.lobbyShop.shops;

import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.managers.ThreadManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Matthew on 4/07/2016.
 */
public abstract class Shop {


    private String title;
    private int size;
    private HashMap<Integer,ShopItem> itemsMap;


    public Shop(String title, int size){
        this.title = title;
        this.size = size;

        itemsMap = new HashMap<>();
    }

    public void display(Player p){
        p.playSound(p.getLocation(), Sound.CLICK,1F,1F);
        ThreadManager.get().run(new Runnable() {
            @Override
            public void run() {
                Inventory i = Bukkit.createInventory(null,size,title);

                for(Map.Entry<Integer,ShopItem> entry : itemsMap.entrySet())
                    i.setItem(entry.getKey(), entry.getValue().getItem(p));

                fillInventory(p,i);
                p.openInventory(i);
            }
        });
    }

    protected abstract void fillInventory(Player p ,Inventory i);

    protected boolean onPlayerClick(InventoryClickEvent evt) {
        ItemStack item = evt.getCurrentItem();
        String name = item.getItemMeta().getDisplayName();
        for(Map.Entry<Integer,ShopItem> entry : itemsMap.entrySet()){
            if(entry.getValue().getItem().getItemMeta().getDisplayName().equals(name)){
                ThreadManager.get().run(new Runnable() {
                    @Override
                    public void run() {
                        if(entry.getValue().canBuy((Player) evt.getWhoClicked())){
                            entry.getValue().buy((Player) evt.getWhoClicked());
                        }
                    }
                });
                return true;
            }
        }
        return false;

    }


    protected void addItem(int slot,ShopItem item){
        itemsMap.put(slot,item);
    }

    public String getTitle(){
        return title;
    }


}

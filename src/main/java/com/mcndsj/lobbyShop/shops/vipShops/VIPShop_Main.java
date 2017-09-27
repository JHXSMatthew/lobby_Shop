package com.mcndsj.lobbyShop.shops.vipShops;

import com.mcndsj.lobbyShop.items.vipShopItems.buyItems.VIPPreBuyItems;
import com.mcndsj.lobbyShop.shops.Shop;
import com.mcndsj.lobby_Vip.api.VipType;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * Created by Matthew on 4/07/2016.
 */
public class VIPShop_Main extends Shop {

    private static String title = "会员商店";
    public VIPShop_Main() {
        super(title,27);
        addItem(10,new VIPPreBuyItems(VipType.VIP));
        addItem(12,new VIPPreBuyItems(VipType.VIP_PLUS));
        addItem(14,new VIPPreBuyItems(VipType.MVP));
        addItem(16,new VIPPreBuyItems(VipType.MVP_PLUS));
    }

    @Override
    protected void fillInventory(Player p, Inventory i) {

    }
}

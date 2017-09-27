package com.mcndsj.lobbyShop.items.vipShopItems.infoItems;

import com.mcndsj.lobbyMoney.MoneyType;
import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.utils.ItemFactory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew on 7/07/2016.
 */
public class VIPShopInfoItems extends ShopItem{
    public VIPShopInfoItems(Material m, String ...lore) {
        super(0,ItemFactory.createLobbyVIPItem(m,(byte)0," ",lore) ,MoneyType.money);
    }

    @Override
    protected boolean canBuyCheck(Player p) {
        return true;
    }

    @Override
    public boolean buy(Player p) {
        return true;
    }

    @Override
    public ItemStack getItem(Player p) {
        return getItem();
    }

    @Override
    public int getCost(Player p) {
        return 0;
    }
}

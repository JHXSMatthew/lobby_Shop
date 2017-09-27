package com.mcndsj.lobbyShop.items.personalInfo;

import com.mcndsj.Lobby_Display.Lobby_Display;
import com.mcndsj.lobbyMoney.MoneyType;
import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.managers.ShopManager;
import com.mcndsj.lobbyShop.utils.ItemFactory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew on 7/07/2016.
 */
public class PrefixMenuShopItem extends ShopItem{
    public PrefixMenuShopItem() {
        super(0, ItemFactory.create(Material.NETHER_STAR,(byte)0, ChatColor.GREEN  +"称号簿"
                ,"点击查看更换个人称号"), MoneyType.money);
    }

    @Override
    protected boolean canBuyCheck(Player p) {
        return true;
    }

    @Override
    public boolean buy(Player p) {
        Lobby_Display.getInstance().getApi().openPrefixInventory(p);
        return true;
    }

    @Override
    public ItemStack getItem(Player p) {
        return getItem();
    }

    @Override
    public int getCost(Player p) {
        return getCost();
    }
}

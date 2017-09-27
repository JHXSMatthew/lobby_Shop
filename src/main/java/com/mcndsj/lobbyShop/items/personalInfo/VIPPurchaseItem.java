package com.mcndsj.lobbyShop.items.personalInfo;

import com.mcndsj.lobbyMoney.MoneyType;
import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.managers.ShopManager;
import com.mcndsj.lobbyShop.shops.vipShops.VIPShop_Main;
import com.mcndsj.lobbyShop.utils.ItemBuilder;
import com.mcndsj.lobbyShop.utils.ItemFactory;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew on 10/07/2016.
 */
public class VIPPurchaseItem extends ShopItem {
    public VIPPurchaseItem() {
        super(0, new ItemBuilder(
                ChatColor.GREEN  +"购买会员"
                , Material.EMERALD
                , ChatColor.GRAY  +"点击购买会员."
                ,ChatColor.RED  +"遵守Mojang官方EULA原则"
                ,ChatColor.GRAY  +" "
                ,ChatColor.GRAY  +"充值点券请关注官方信息"
                ,ChatColor.GRAY  +"www.mcndsj.com")
                .setEnchantment(Enchantment.DURABILITY,1)
                .build(), MoneyType.money);
    }

    @Override
    protected boolean canBuyCheck(Player p) {
        return true;
    }

    @Override
    public boolean buy(Player p) {
        p.closeInventory();
        ShopManager.get().openShop(p,VIPShop_Main.class);
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

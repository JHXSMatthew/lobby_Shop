package com.mcndsj.lobbyShop.shops.personalInfo;

import com.mcndsj.lobbyShop.items.personalInfo.*;
import com.mcndsj.lobbyShop.shops.Shop;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

/**
 * Created by Matthew on 4/07/2016.
 */
public class PersonalInfo_Main extends Shop {

    private static String title = "个人信息";

    public PersonalInfo_Main() {
        super(title, 54);
        addItem(4,new PointDonationShopItem());
        addItem(14,new PrefixMenuShopItem());
        addItem(32,new PremiumPrefixShopItem());
        addItem(33,new PremiumDePrefixShopItem());
        addItem(30,new VIPPurchaseItem());
    }

    @Override
    protected void fillInventory(Player p, Inventory i) {

    }

}

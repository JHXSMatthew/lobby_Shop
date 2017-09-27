package com.mcndsj.lobbyShop.items.vipShopItems.buyItems;

import com.mcndsj.lobbyMoney.MoneyType;
import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.managers.ShopManager;
import com.mcndsj.lobbyShop.shops.vipShops.VIPShop_Buy;
import com.mcndsj.lobbyShop.utils.ItemBuilder;
import com.mcndsj.lobbyShop.utils.VIPUtils;
import com.mcndsj.lobby_Vip.api.VipType;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew on 10/07/2016.
 */
public class VIPPreBuyItems extends ShopItem {
    private VipType type;
    public VIPPreBuyItems(VipType type) {
        super(0, new ItemBuilder(type.toString(),VIPUtils.vipBuyMaterial(type), ChatColor.GRAY + "点击查看详情.").build(), MoneyType.money);
        this.type = type;

    }

    @Override
    protected boolean canBuyCheck(Player p) {
        return true;
    }

    @Override
    public boolean buy(Player p) {
        p.closeInventory();
        ShopManager.get().openShopDynamically(p,new VIPShop_Buy(type));
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

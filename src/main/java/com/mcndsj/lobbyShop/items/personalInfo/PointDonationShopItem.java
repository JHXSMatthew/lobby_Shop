package com.mcndsj.lobbyShop.items.personalInfo;

import com.mcndsj.lobbyMoney.MoneyType;
import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.utils.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

/**
 * Created by Matthew on 10/07/2016.
 */
public class PointDonationShopItem extends ShopItem {
    public PointDonationShopItem() {
        super(0, com.mcndsj.lobbyShop.utils.ItemFactory.create(Material.EMERALD_BLOCK,(byte)0,ChatColor.GOLD  +"赞助点券"," ", ChatColor.GRAY + "点券是赞助获取的一种货币"," ",ChatColor.RED + "点击物品",ChatColor.GRAY  +"并查看左下角聊天栏.",ChatColor.GRAY  +"获取充值赞助点券地址"), MoneyType.money);
    }

    @Override
    protected boolean canBuyCheck(Player p) {
        return true;
    }

    @Override
    public boolean buy(Player p) {
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "tellraw "+  p.getName() + " {text:\""+ ChatColor.RED +"✦点击赞助✦ ✦点击赞助✦ ✦点击赞助✦.\",clickEvent:{action:open_url,value:\"http://www.mcndsj.com/forum.php?mod=viewthread&tid=198&extra=page%3D1\"}}");
        p.closeInventory();
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

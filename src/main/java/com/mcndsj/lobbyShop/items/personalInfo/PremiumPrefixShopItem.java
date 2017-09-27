package com.mcndsj.lobbyShop.items.personalInfo;

import com.mcndsj.Lobby_Display.Lobby_Display;
import com.mcndsj.Lobby_Display.Prefix.PrefixController;
import com.mcndsj.lobbyMoney.MoneyType;
import com.mcndsj.lobbyShop.Config;
import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.utils.ItemFactory;
import com.mcndsj.lobbyShop.utils.SQLUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Matthew on 7/07/2016.
 */
public class PremiumPrefixShopItem extends ShopItem {
    public PremiumPrefixShopItem() {
        super(0, ItemFactory.create(Material.ENDER_PEARL,(byte)0, ChatColor.GREEN  +"正版认证" ,
                ChatColor.YELLOW  +"点击确认正版认证,获取正版称号."
                ,ChatColor.RED  +"您需要先按照论坛认证教程帖步骤去做."
                ,ChatColor.RED  +"才可以点击此处获取正版称号."
                ,ChatColor.GRAY  +" "
                ,ChatColor.GRAY  +"认证详情请查看论坛综合讨论区置顶帖"
                ,ChatColor.GRAY  +"www.mcndsj.com"), MoneyType.money);
    }

    @Override
    protected boolean canBuyCheck(Player p) {
        int i = SQLUtils.isGiven(p.getName());
        if(i == 0){
            return true;
        }
        if(i == -1){
            p.sendMessage(Config.prefix + "您尚未按照步骤进行正版认证,请按照www.mcndsj.com综合讨论区置顶帖进行认证!");
        }else if(i == 1){
            p.sendMessage(Config.prefix + "您已经完成了正版认证!");
        }
        p.closeInventory();
        return false;
    }

    @Override
    public boolean buy(Player p) {
        SQLUtils.setGiven(p.getName());
        Lobby_Display.getInstance().getApi().addPrefix(p,7);
        p.sendMessage(Config.prefix + "正版认证成功,下次您加入游戏时会自动获取您的皮肤.使用个人信息可以更换称号!");
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

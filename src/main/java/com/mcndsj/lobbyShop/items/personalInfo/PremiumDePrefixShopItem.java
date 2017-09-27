package com.mcndsj.lobbyShop.items.personalInfo;

import com.mcndsj.Lobby_Display.Lobby_Display;
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
public class PremiumDePrefixShopItem extends ShopItem {
    public PremiumDePrefixShopItem() {
        super(0, ItemFactory.create(Material.ENDER_PORTAL_FRAME,(byte)0, ChatColor.GREEN  +"取消正版认证" ,
                ChatColor.YELLOW  +"点击取消正版认证!"
                ,ChatColor.RED  +"仅限已进行正版认证用户改名使用.."
                ,ChatColor.RED  +"点击后正版认证称号将消失,皮肤将无法显示."
                ,ChatColor.GRAY  +" "
                ,ChatColor.GRAY  +"再次认证详情请查看论坛综合讨论区置顶帖"
                ,ChatColor.GRAY  +"www.mcndsj.com"), MoneyType.money);
    }

    @Override
    protected boolean canBuyCheck(Player p) {
        int i = SQLUtils.isGiven(p.getName());
        if(i == 0){
            p.sendMessage(Config.prefix + "您需要领取称号而不是去除称号!");
            p.closeInventory();
            return false;
        }
        if(i == -1){
            p.sendMessage(Config.prefix + "您尚未按照步骤进行正版认证,请按照www.mcndsj.com综合讨论区置顶帖进行认证!");
            p.closeInventory();
            return false;
        }else if(i == 1){
            return true;
        }
        p.closeInventory();
        return false;
    }

    @Override
    public boolean buy(Player p) {
        SQLUtils.deletePremium(p.getName());
        Lobby_Display.getInstance().getApi().removePrefix(p,7);
        p.sendMessage(Config.prefix + "去除正版认证成功,您的称号已清除,感谢您的支持!");
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

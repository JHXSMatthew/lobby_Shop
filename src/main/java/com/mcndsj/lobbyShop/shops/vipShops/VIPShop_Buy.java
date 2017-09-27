package com.mcndsj.lobbyShop.shops.vipShops;

import com.mcndsj.lobbyShop.items.vipShopItems.buyItems.VIPBuyItem;
import com.mcndsj.lobbyShop.items.vipShopItems.infoItems.VIPShopInfoItems;
import com.mcndsj.lobbyShop.shops.Shop;
import com.mcndsj.lobby_Vip.api.VipType;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created by Matthew on 7/07/2016.
 */
public class VIPShop_Buy extends Shop {
    private VipType type;
    public VIPShop_Buy(VipType type) {
        super(type.toString(), 27);
        this.type = type;
        switch (type){
            case VIP:
                addItem(0,new VIPShopInfoItems(Material.ANVIL
                        ,ChatColor.DARK_AQUA + "尊享称号: " + type.toString() +"✔"
                        ,ChatColor.DARK_AQUA + "进入大厅提示"
                        ,ChatColor.DARK_AQUA + "特殊聊天字体颜色",
                        ChatColor.DARK_AQUA + "满人进入大厅",
                        ChatColor.DARK_AQUA + "内测游戏权限",
                        ChatColor.DARK_AQUA + "帮助服务器生存发展"));
                addItem(1,new VIPShopInfoItems(Material.SLIME_BALL
                        ,ChatColor.DARK_AQUA + "变形术-猪"));
                addItem(2,new VIPShopInfoItems(Material.BEACON
                        ,ChatColor.DARK_AQUA + "立即获得 "+ ChatColor.GREEN + "1" + ChatColor.DARK_AQUA + " 个珍藏宝箱"
                        ,ChatColor.DARK_AQUA + "每月领取 "+ ChatColor.GREEN + "1" + ChatColor.DARK_AQUA + " 个珍藏宝箱",
                        " ",
                        ChatColor.DARK_GRAY + "注:升级会员将不会获得宝箱奖励"));
                break;
            case VIP_PLUS:
                addItem(0,new VIPShopInfoItems(Material.ANVIL
                        ,ChatColor.DARK_AQUA + "尊享称号: " + type.toString() +"✔"
                        ,ChatColor.DARK_AQUA + "进入大厅提示"
                        ,ChatColor.DARK_AQUA + "特殊聊天字体颜色",
                        ChatColor.DARK_AQUA + "满人进入大厅",
                        ChatColor.DARK_AQUA + "内测游戏权限",
                        ChatColor.DARK_AQUA + "去除聊天间隔"));
                addItem(1,new VIPShopInfoItems(Material.SLIME_BALL
                        ,ChatColor.DARK_AQUA + "变形术-猪",
                        ChatColor.DARK_AQUA + "坐骑-不死之马",
                        ChatColor.DARK_AQUA + "变形术-爬行者"));
                addItem(2,new VIPShopInfoItems(Material.BEACON
                        ,ChatColor.DARK_AQUA + "立即获得 "+ ChatColor.GREEN + "2" + ChatColor.DARK_AQUA + " 个珍藏宝箱"
                        ,ChatColor.DARK_AQUA + "每月领取 "+ ChatColor.GREEN + "2" + ChatColor.DARK_AQUA + " 个珍藏宝箱",
                        " ",
                        ChatColor.DARK_GRAY + "注:升级会员将不会获得宝箱奖励"));
                break;
            case MVP:
                addItem(0,new VIPShopInfoItems(Material.ANVIL
                        ,ChatColor.DARK_AQUA + "尊享称号: " + type.toString() +"✔"
                        ,ChatColor.DARK_AQUA + "进入大厅提示"
                        ,ChatColor.DARK_AQUA + "特殊聊天字体颜色",
                        ChatColor.DARK_AQUA + "满人进入大厅",
                        ChatColor.DARK_AQUA + "绿色通道优先加入",
                        ChatColor.DARK_AQUA + "内测游戏权限",
                        ChatColor.DARK_AQUA + "申请YourCraft团队职位权限",
                        ChatColor.DARK_AQUA + "去除聊天间隔"));
                addItem(1,new VIPShopInfoItems(Material.SLIME_BALL
                        ,ChatColor.DARK_AQUA + "宠物-喜洋洋",
                        ChatColor.DARK_AQUA + "坐骑-不死之马",
                        ChatColor.DARK_AQUA + "坐骑-矿车",
                        ChatColor.DARK_AQUA + "变形术-爬行者",
                        ChatColor.DARK_AQUA + "变形术-猪",
                        ChatColor.DARK_AQUA + "变形术-烈焰人",
                        ChatColor.DARK_AQUA + "粒子效果-火焰光环"));
                addItem(2,new VIPShopInfoItems(Material.BEACON
                        ,ChatColor.DARK_AQUA + "立即获得 "+ ChatColor.GREEN + "3" + ChatColor.DARK_AQUA + " 个珍藏宝箱"
                        ,ChatColor.DARK_AQUA + "每月领取 "+ ChatColor.GREEN + "3" + ChatColor.DARK_AQUA + " 个珍藏宝箱",
                        " ",
                        ChatColor.DARK_GRAY + "注:升级会员将不会获得宝箱奖励"));
                break;
            case MVP_PLUS:
                addItem(0,new VIPShopInfoItems(Material.ANVIL
                        ,ChatColor.DARK_AQUA + "尊享称号: " + type.toString() +"✔"
                        ,ChatColor.DARK_AQUA + "进入大厅提示"
                        ,ChatColor.DARK_AQUA + "特殊聊天字体颜色",
                        ChatColor.DARK_AQUA + "满人进入大厅",
                        ChatColor.DARK_AQUA + "绿色通道优先加入",
                        ChatColor.DARK_AQUA + "内测游戏权限",
                        ChatColor.DARK_AQUA + "去除聊天间隔",
                        ChatColor.DARK_AQUA + "优先申请YourCraft团队职位权限"
                      ));
                addItem(1,new VIPShopInfoItems(Material.SLIME_BALL,
                        ChatColor.DARK_AQUA + "表情包-四十余表情全部解锁"
                        ,ChatColor.DARK_AQUA + "宠物-喜洋洋",
                        ChatColor.DARK_AQUA + "坐骑-不死之马",
                        ChatColor.DARK_AQUA + "坐骑-矿车",
                        ChatColor.DARK_AQUA + "坐骑-奔跑七色羊",
                        ChatColor.DARK_AQUA + "变形术-爬行者",
                        ChatColor.DARK_AQUA + "变形术-猪",
                        ChatColor.DARK_AQUA + "变形术-烈焰人",
                        ChatColor.DARK_AQUA + "变形术-凋零骷髅",
                        ChatColor.DARK_AQUA + "粒子效果-火焰光环"));
                addItem(2,new VIPShopInfoItems(Material.BEACON
                        ,ChatColor.DARK_AQUA + "立即获得 "+ ChatColor.GREEN + "5" + ChatColor.DARK_AQUA + " 个珍藏宝箱"
                        ,ChatColor.DARK_AQUA + "每月领取 "+ ChatColor.GREEN + "5" + ChatColor.DARK_AQUA + " 个珍藏宝箱",
                        ChatColor.DARK_AQUA + "论坛优先处理权限",
                        " ",
                        ChatColor.DARK_GRAY + "注:升级会员将不会获得宝箱奖励"));
                break;
        }
        addItem(26,new VIPBuyItem(type));

    }

    @Override
    protected void fillInventory(Player p, Inventory i) {

    }
}

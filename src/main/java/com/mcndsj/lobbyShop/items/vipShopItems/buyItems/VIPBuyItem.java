package com.mcndsj.lobbyShop.items.vipShopItems.buyItems;

import com.mcndsj.Lobby_Display.Lobby_Display;
import com.mcndsj.lobbyMoney.MoneyType;
import com.mcndsj.lobbyMoney.api.LobbyMoneyApi;
import com.mcndsj.lobbyShop.Config;
import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.utils.ItemFactory;
import com.mcndsj.lobbyShop.utils.SQLUtils;
import com.mcndsj.lobbyShop.utils.VIPUtils;
import com.mcndsj.lobby_Vip.LobbyVip;
import com.mcndsj.lobby_Vip.api.VipType;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matthew on 7/07/2016.
 */
public class VIPBuyItem extends ShopItem {


    private VipType type;

    public VIPBuyItem(VipType type) {
        super(VIPUtils.getPrice(type,true), ItemFactory.create(Material.DIAMOND,(byte) 0,ChatColor.RED + ChatColor.BOLD.toString() +"确认购买"), MoneyType.point);
        this.type = type;
    }

    @Override
    protected boolean canBuyCheck(Player p) {
        if(LobbyVip.getApi().getvipType(p.getName()) == null)
            return true;

        if(LobbyVip.getApi().getvipType(p.getName()).getLevel() >= type.getLevel()){
            p.sendMessage(Config.prefix + "您已经是更高级或同级的会员了,无法购买低级会员.");
            return false;
        }

        return true;
    }

    @Override
    public boolean buy(Player p) {
        LobbyMoneyApi.get().setCurrency(p.getName(),getCostType(),LobbyMoneyApi.get().getCurrency(p.getName(),getCostType()) - getCost(p));
        LobbyVip.getApi().setVip(new VIPBuyCallBack(p.getName(),this),p.getName(),type);
        Lobby_Display.getInstance().getApi().addPrefix(p,type.getLevel());
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"uc give key " + VIPUtils.getInitChest(type)+ " " + p.getName());

        p.sendMessage(Config.prefix + "感谢您购买我们的永久" + type.toString() + "✔"+ ChatColor.GRAY + ",祝您在YourCraft游戏愉快!");
        p.sendMessage(Config.prefix + "您可以使用个人信息中的称号簿功能更换会员称号!");
        p.sendMessage(Config.prefix + "如果您是初次购买,我们强烈建议您重新加入游戏,以便全部权限生效!");

        p.playSound(p.getLocation(), Sound.LEVEL_UP,1F,1F);
        p.closeInventory();
        return true;
    }

    @Override
    public ItemStack getItem(Player p) {
        if(canBuyCheck(p)){
            ItemStack item = getItem().clone();
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add(" ");
            if(LobbyVip.getApi().getvipType(p.getName()) == null){

            }else{
                lore.add(ChatColor.GRAY + "当前会员: " +  LobbyVip.getApi().getvipType(p.getName()).toString());
            }
            lore.add(ChatColor.GRAY + "购买会员: " + type.toString());
            lore.add(ChatColor.GRAY + "购买时限: " + ChatColor.RED + "永久");
            lore.add(" ");
            lore.add(ChatColor.GRAY + "限时折扣: " + ChatColor.GREEN + (100 - VIPUtils.getDiscount() * 100) + "%");
            if (VIPUtils.getDiscount() < 1) {
                lore.add(ChatColor.GRAY + "原价: " + ChatColor.STRIKETHROUGH + VIPUtils.getNeed(LobbyVip.getApi().getvipType(p.getName()),type,false) + " 点券");
                if(LobbyVip.getApi().getvipType(p.getName()) == null)
                    lore.add(ChatColor.RED + "特价: " + getCost(p) + " 点券");
                else
                    lore.add(ChatColor.RED + "升级特价: " + getCost(p) + " 点券");

            } else {
                if(LobbyVip.getApi().getvipType(p.getName()) == null)
                    lore.add(ChatColor.RED + "售价: " + getCost(p)+ " 点券");
                else
                    lore.add(ChatColor.RED + "升级差价: " + getCost(p) + " 点券");
            }

            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }else {
            return new ItemStack(Material.AIR);
        }
    }

    public VipType getType(){
        return type;
    }

    @Override
    public int getCost(Player p) {
        return  VIPUtils.getNeed(LobbyVip.getApi().getvipType(p.getName()),type,true);
    }

}

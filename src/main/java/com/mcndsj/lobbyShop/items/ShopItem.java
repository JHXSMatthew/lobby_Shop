package com.mcndsj.lobbyShop.items;

import com.mcndsj.lobbyMoney.MoneyType;
import com.mcndsj.lobbyMoney.api.LobbyMoneyApi;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
/**
 * Created by Matthew on 4/07/2016.
 */
public abstract class ShopItem {
    private int cost;
    private MoneyType costType;
    private ItemStack item;

    public ShopItem(int cost, ItemStack item, MoneyType money){
        this.cost = cost;
        this.item = item;
        this.costType = money;
    }

    /*
    Warning , sync IOoperation Here
     */
    public boolean canBuy(Player p){
        boolean returnValue = true;
        if(cost != 0){
            int current = LobbyMoneyApi.get().getCurrency(p.getName(),costType);
            int need = getCost(p);
            System.out.println(current + "/" +  need);
            if(current < need) {
                p.sendMessage(ChatColor.AQUA + "提示 >> " + ChatColor.GRAY + "您的" + costType.toString() + "余额不足,您还需 " + (need - current) + " " + costType.toString() + "才可以购买!" );
                p.closeInventory();
                return false;
            }
        }
        returnValue = returnValue && canBuyCheck(p);
        return returnValue;
    }

    /**
     *
     * @param p the player who wants to buy it
     * @return  precondition of buy method sound or not
     */
    protected abstract boolean canBuyCheck(Player p);

    /**
     *
     * @param p player who buy it
     * @return success or fail
     */
    public abstract boolean buy(Player p );

    /**
     *
     * @param p the player showing to
     * @return the itemStack showing to that player
     */
    public abstract ItemStack getItem(Player p);

    /**
     *
     * @param p the player who want to buy it
     * @return the cost for that player
     */

    public abstract int getCost(Player p);


    public int getCost(){
        return cost;
    }

    public MoneyType getCostType(){
        return costType;
    }


    public ItemStack getItem(){
        return item;
    }


}

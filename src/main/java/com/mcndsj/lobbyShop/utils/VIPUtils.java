package com.mcndsj.lobbyShop.utils;

import com.mcndsj.lobby_Vip.api.VipType;
import org.bukkit.Material;

/**
 * Created by Matthew on 10/07/2016.
 */
public class VIPUtils {
    private static double discount = 1;


    public static int getNeed(VipType from , VipType to,boolean dis){
        return getPrice(to,dis) - getPrice(from,dis);
    }

    public static int getPrice(VipType to,boolean dis){
        int price = 0;
        if(to == null)
            return price;

        switch (to){
            case VIP:
                price = 12000;
                break;
            case VIP_PLUS:
                price = 20000;
                break;
            case MVP:
                price = 40000;
                break;
            case MVP_PLUS:
                price = 60000;
                break;
            default:
                price = 0;
        }
        if(dis){
            return (int) (price * discount);
        }else{
            return  price ;
        }
    }

    public static Material vipBuyMaterial(VipType type){
        switch (type){
            case VIP:
                return Material.IRON_BLOCK;
            case VIP_PLUS:
                return Material.GOLD_BLOCK;
            case MVP:
                return Material.DIAMOND_BLOCK;
            case MVP_PLUS:
                return Material.EMERALD_BLOCK;
        }
        return Material.AIR;
    }

    public static String getGroupName(VipType type){
        switch (type){
            case VIP:
                return "vip1";
            case VIP_PLUS:
                return "vip2";
            case MVP:
                return "vip3";
            case MVP_PLUS:
                return "vip4";
        }
        return "default";
    }

    public static int getInitChest(VipType type){
        switch (type){
            case VIP:
                return 1;
            case VIP_PLUS:
                return 2;
            case MVP:
                return 3;
            case MVP_PLUS:
                return 5;
        }
        return 0;
    }

    public static double getDiscount(){
        return discount;
    }
}

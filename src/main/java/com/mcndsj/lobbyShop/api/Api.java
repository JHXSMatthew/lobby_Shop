package com.mcndsj.lobbyShop.api;

import com.mcndsj.lobbyShop.managers.ShopManager;
import org.bukkit.entity.Player;

/**
 * Created by Matthew on 7/07/2016.
 */
public class Api {

    private static Api api;

    public void openShop(Player p , ShopType type){
        ShopManager.get().openShop(p,type.getClazz());
    }


    public static Api getApi(){
        if(api == null){
            api = new Api();
        }
        return api;
    }
}

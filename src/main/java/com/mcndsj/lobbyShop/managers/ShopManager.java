package com.mcndsj.lobbyShop.managers;

import com.mcndsj.lobbyShop.items.ShopItem;
import com.mcndsj.lobbyShop.shops.Shop;
import com.mcndsj.lobbyShop.shops.ShopListener;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created by Matthew on 4/07/2016.
 */
public class ShopManager {

    private static ShopManager manager;
    private HashMap<Class<? extends Shop>,Shop> shops;

    public ShopManager(){
        shops = new HashMap<>();
    }

    public void openShop(Player p,Class<?extends Shop> clazz){
        Shop s = null;
        if(shops.containsKey(clazz)){
            s = shops.get(clazz);
        }else{
            try {
                s = clazz.getDeclaredConstructor().newInstance();
                shops.put(clazz,s);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        ShopListener sl = new ShopListener(p.getName(),s);
        s.display(p);
    }

    public void openShopDynamically(Player p , Shop sp){
        ShopListener sl = new ShopListener(p.getName(),sp);
        sp.display(p);
        System.out.println("Shop Should displayed for player "  + p.getName());
    }

    public static ShopManager get(){
        if(manager == null){
            manager = new ShopManager();
        }

        return manager;
    }
}

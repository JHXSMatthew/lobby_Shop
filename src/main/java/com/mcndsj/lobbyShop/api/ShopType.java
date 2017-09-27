package com.mcndsj.lobbyShop.api;

import com.mcndsj.lobbyShop.shops.Shop;
import com.mcndsj.lobbyShop.shops.personalInfo.PersonalInfo_Main;

/**
 * Created by Matthew on 7/07/2016.
 */
public enum ShopType {

    personalInfo(PersonalInfo_Main.class);

    private Class<?extends Shop> clazz;

    ShopType(Class <? extends Shop> clazz){
        this.clazz = clazz;
    }

    public Class<? extends Shop> getClazz(){
        return clazz;
    }

}

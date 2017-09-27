package com.mcndsj.lobbyShop.items.vipShopItems.buyItems;

import com.mcndsj.Lobby_Display.Lobby_Display;
import com.mcndsj.lobbyShop.utils.VIPUtils;
import com.mcndsj.lobby_Vip.LobbyVip;
import com.mcndsj.lobby_Vip.api.SetVipEvent;
import com.mcndsj.lobby_Vip.api.VipType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

/**
 * Created by Matthew on 7/07/2016.
 */
public class VIPBuyCallBack implements SetVipEvent {


    private VIPBuyItem fac;
    private String player;

    public VIPBuyCallBack(String player,VIPBuyItem factory){
        this.player = player;
        this.fac = factory;
    }

    @Override
    public void callBack(boolean b) {
        Player p = Bukkit.getPlayer(player);
        if(p == null){
            return;
        }
        PermissionUser user = PermissionsEx.getUser(p);
        VipType used = LobbyVip.getApi().getvipType(p.getName());
        if(user == null){
            return;
        }
        if(used != null) {
            user.removeGroup(VIPUtils.getGroupName(used));
            Lobby_Display.getInstance().getApi().removePrefix(p,used.getLevel());
        }
        user.addGroup(VIPUtils.getGroupName(fac.getType()));

    }
}

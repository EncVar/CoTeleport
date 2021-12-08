package top.whitecola.coteleport.struct;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import top.whitecola.coteleport.CoTeleport;
import top.whitecola.coteleport.utils.TeleportUtils;

public class BackRequest extends AbstractRequest{

    public BackRequest(Player from, Location location){
        this.from = from;
        this.tolcation = location;
        time = System.currentTimeMillis();
    }

    @Override
    public void submitRequest() {
        from.sendMessage("��e���ϴ������� "+from.getWorld().getName()+" ���� "+from.getLocation().getBlockX()+" "+from.getLocation().getBlockY()+" "+from.getLocation().getBlockZ()+" ���� /ct back ������һ���ص㡣");
        from.getPlayer().getPlayer().spigot().sendMessage
                (new ComponentBuilder("��2��l�����˴��ص��ϸ��ص�").event
                        (new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/ct back").create()))
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ct back")).create());


        CoTeleport.instance.getPlayerBackHandler().addRequest(this);
    }

    @Override
    public void accept() {
        TeleportUtils.tpaRequestHandle(this,new PlayerNoticer(from,null));
    }

    @Override
    public void deny() {
        playsound();
        CoTeleport.instance.getPlayerBackHandler().removeRequest(this);
        from.sendMessage("��4�ص���һ���ص�������ѱ��������ܾ���");

    }

    @Override
    public void cancel() {
        CoTeleport.instance.getPlayerBackHandler().removeRequest(this);
    }

    @Override
    public void playsound() {
        from.getPlayer().playSound(from.getLocation(), Sound.ENTITY_ITEM_PICKUP,2,2);
    }
}

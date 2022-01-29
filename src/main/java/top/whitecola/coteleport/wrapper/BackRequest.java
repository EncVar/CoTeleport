package top.whitecola.coteleport.wrapper;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import top.whitecola.coteleport.handler.PlayerBackHandler;
import top.whitecola.coteleport.utils.HandlerUtils;
import top.whitecola.coteleport.utils.TeleportUtils;

public class BackRequest extends AbstractRequest{

    public BackRequest(Player from, Location location){
        this.from = from;
        this.tolcation = location;
    }

    @Override
    public void submitRequest() {
        super.submitRequest();
        from.sendMessage("��e���ϴ������� "+from.getWorld().getName()+" ���� "+from.getLocation().getBlockX()+" "+from.getLocation().getBlockY()+" "+from.getLocation().getBlockZ()+" ���� /ct back ������һ���ص㡣");
        from.getPlayer().getPlayer().spigot().sendMessage
                (new ComponentBuilder("��2��l�����˴��ص��ϸ��ص�").event
                        (new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/ct back").create()))
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ct back")).create());


    }

    @Override
    public void accept() {
        time = System.currentTimeMillis();
        TeleportUtils.tpaRequestHandle(this,new PlayerNoticer(from,null));
    }

    @Override
    public void deny() {
        super.deny();
        from.sendMessage("��4�ص���һ���ص�������ѱ��������ܾ���");
    }


    @Override
    public void cancel() {
        super.cancel();
    }

}

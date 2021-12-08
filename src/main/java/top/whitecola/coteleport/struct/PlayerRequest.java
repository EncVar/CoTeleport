package top.whitecola.coteleport.struct;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import top.whitecola.coteleport.CoTeleport;
import top.whitecola.coteleport.utils.TeleportUtils;


public class PlayerRequest extends AbstractRequest{
   public Player to;

    public PlayerRequest(Player from,Player to){
        this.from = from;
        this.to = to;
        this.tolcation = to.getLocation();
    }
    @Override
    public void submitRequest(){
        playsound();
        from.getPlayer().sendMessage("��e������� "+to.getName()+" ���ʹ�������");
        to.getPlayer().sendMessage("-------------------------------------");
        to.getPlayer().sendMessage("��e��l�յ��������"+from.getName()+" �Ĵ��͵���������������� /ct tpaccept ͬ�����󣬻����·���");
        to.getPlayer().getPlayer().spigot().sendMessage
                (new ComponentBuilder("��2��l����������������������[ ͬ�� ]����������������������").event
                        (new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/ct tpaccept").create()))
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ct tpaccept")).create());
        to.getPlayer().spigot().sendMessage

                (new ComponentBuilder("��4��l����������������������[ �ܾ� ]����������������������").event
                        (new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("/ct tpadeny").create()))
                        .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/ct tpadeny")).create());
        to.getPlayer().sendMessage("-------------------------------------");


        CoTeleport.instance.teleportEventHandler.addRequest(this);
    }
    @Override
    public void accept(){
        playsound();
        to.getPlayer().sendMessage("��e�ȴ� "+from.getName()+" ���͡�");
        time = System.currentTimeMillis();
        thread = TeleportUtils.tpaRequestHandle(this,new PlayerNoticer(from,to));
    }

    @Override
    public void deny(){
        playsound();
        to.getPlayer().sendMessage("��4�Ѿܾ����� "+ from.getPlayer().getName()+" �Ĵ�������");
        from.sendMessage("��4"+to.getPlayer().getName()+" �ܾ�����Ĵ�������");
        CoTeleport.instance.teleportEventHandler.getRequests().remove(this);
    }

    @Override
    public void cancel(){
        time = -2;
        thread.stop();
        playsound();
        to.getPlayer().sendMessage("��e����ȡ����");
        from.getPlayer().sendMessage("��e�������ڴ��͹������ƶ��������ѱ�ȡ����");

    }

    @Override
    public void playsound(){
        from.getPlayer().playSound(from.getLocation(), Sound.ENTITY_ITEM_PICKUP,2,2);
        to.getPlayer().playSound(from.getLocation(), Sound.ENTITY_ITEM_PICKUP,2,2);
    }


}

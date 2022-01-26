package top.whitecola.coteleport.wrapper;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import top.whitecola.coteleport.utils.TeleportUtils;

public class SpawnRequest extends AbstractRequest{

    public SpawnRequest(Player from, Location to){
        this.from = from;
        this.tolcation = to;
    }

    @Override
    public void submitRequest() {
        from.sendMessage("��e�Ѿ������������س�����");
    }

    @Override
    public void accept() {
        playsound();
        from.sendMessage("��a��l������ͬ������Ļس����󣬼������͡�");
        time = System.currentTimeMillis();
        thread = TeleportUtils.tpaRequestHandle(this,new PlayerNoticer(from,null));

    }

    @Override
    public void deny() {
        from.sendMessage("��4��l�س������ѱ����������أ�ԭ��"+"ү��û�ѹ���д�á�");
    }

    @Override
    public void cancel() {
        from.sendMessage("��4�س������ѱ�������ȡ����");

    }

    @Override
    public void playsound() {
        from.getPlayer().playSound(from.getLocation(), Sound.ENTITY_ITEM_PICKUP,2,2);


    }

}

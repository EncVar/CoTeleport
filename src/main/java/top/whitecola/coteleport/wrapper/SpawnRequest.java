package top.whitecola.coteleport.wrapper;

import org.bukkit.Location;
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
        super.accept();
        from.sendMessage("��a��l������ͬ������Ļس����󣬼������͡�");
        thread = TeleportUtils.tpaRequestHandle(this,new PlayerNoticer(from,null));

    }

    @Override
    public void deny() {
        super.deny();
        from.sendMessage("��4��l�س������ѱ�����������");
    }

    @Override
    public void cancel() {
        super.cancel();
        from.sendMessage("��4�س������ѱ�������ȡ����");

    }


}

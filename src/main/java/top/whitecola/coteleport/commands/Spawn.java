package top.whitecola.coteleport.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import top.whitecola.annotations.ItsACommand;
import top.whitecola.commandhandler.ICommand;
import top.whitecola.coteleport.struct.AbstractRequest;
import top.whitecola.coteleport.struct.PlayerRequest;
import top.whitecola.coteleport.struct.SpawnRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


@ItsACommand(CommandNmae = "spawn",premission = "ct.spawn")
public class Spawn implements ICommand {
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(!(commandSender instanceof Player))
            return false;

        Player fromP = (Player) commandSender;

        if(fromP.getBedSpawnLocation()==null){
            fromP.sendMessage("�ٴ�֮ǰ�������ô����ó����㡣");
            return true;
        }

        AbstractRequest spawnRequest = new SpawnRequest(fromP,fromP.getBedSpawnLocation());
        spawnRequest.submitRequest();
        spawnRequest.accept();
        return true;
    }

    public List<String> getArgs() {
        return Arrays.asList("");
    }

    public List<String> handleArg(CommandSender sender, String handleArg) {

            return Arrays.asList("");

    }

    public String getUsage() {
        return "/ct spawn";
    }

    public String getUsageDescripition() {
        return "��ָ����ҷ��ʹ�������";
    }
}


package me.morefeatures.morefeatures.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setname implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player)sender;
            if (args.length == 2){
                if (player.hasPermission("morefeatures.commands.setname")) {
                    //执行此段代码(有权限)
                    String name = args[1];
                    Player entity = (Player) Bukkit.getPlayerExact(args[0]);
                    if (entity instanceof Player) {
                        entity.setCustomName(name);
                    }else {
                        player.sendMessage(entity.getName()+ChatColor.GOLD+"玩家不在线!");
                    }
                } else {
                    //执行此段代码(无权限)
                    player.sendMessage(ChatColor.RED+"你没有morefeatures.commands.setname的权限!");
                }
            }else if (args.length == 1){
                if (player.hasPermission("morefeatures.commands.setname")) {
                    //执行此段代码(有权限)
                    String name = args[1];
                    player.setCustomName(name);
                } else {
                    //执行此段代码(无权限)
                    player.sendMessage(ChatColor.RED+"你没有morefeatures.commands.setname的权限!");
                }
            }
        }else{
            System.out.println(ChatColor.RED+"此指令只能玩家执行(兼容性问题)");
        }
        return false;
    }
}

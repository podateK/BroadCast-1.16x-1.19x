package store.techcode;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadCast implements CommandExecutor {
    Main plugin;

    public BroadCast(Main m) {
        plugin = m;
        m.getCommand("broadcast").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("techcode.broadcast")) {
            if(args.length >= 1) {
                StringBuilder sb = new StringBuilder();

                for(int i = 1; i < args.length; ++i) {
                    sb.append(args[i]).append(" ");
                }

                String msg = sb.toString();

                if(args[0].equalsIgnoreCase("chat")) {
                    for(Player ps : Bukkit.getOnlinePlayers()) {
                        ps.sendMessage("§8[§6Ogloszenie§8] §e" + msg.replace("&", "§"));
                    }
                } else if(args[0].equalsIgnoreCase("title")) {
                    for(Player ps : Bukkit.getOnlinePlayers()) {
                        ps.sendTitle(msg.replace("&", "§")," ");
                    }
                    } else if(args[0].equalsIgnoreCase("actionbar")) {
                        for(Player ps : Bukkit.getOnlinePlayers()) {
                            ps.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(msg.replace("&", "§")));
                        }
                    } else {
                        sender.sendMessage("§7Uzycie komendy: §6/broadcast [title/actionbar/chat] wiadomosc");
                    }
                } else {
                    sender.sendMessage("§7Uzycie komendy: §6/broadcast [title/actionbar/chat] wiadomosc");
                }

                } else {
            sender.sendMessage("§cNie posiadasz permisji do wysylania ogloszen serwerowych §7(techcode.broadcast)");

                }
        return false;
    }

     }








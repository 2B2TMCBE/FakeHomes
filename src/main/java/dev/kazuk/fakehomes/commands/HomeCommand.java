package dev.kazuk.fakehomes.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.network.protocol.DisconnectPacket;
import cn.nukkit.utils.TextFormat;

public class HomeCommand extends Command {

    public HomeCommand() {
        super("home", "Access your homes");
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{
                CommandParameter.newEnum("home", new String[]{"heaven"})
        });
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(TextFormat.RED + "You can only run this command as a player!");
            return true;
        }

        if (args.length <= 0) {
            sender.sendMessage(TextFormat.GREEN + "Available Homes:\n- Heaven");
            return true;
        }

        if (!args[0].equalsIgnoreCase("heaven")) {
            sender.sendMessage(TextFormat.RED + "That home doesn't exist!");
            return true;
        }

        Player player = (Player) sender;
        DisconnectPacket packet = new DisconnectPacket();
        packet.hideDisconnectionScreen = false;
        packet.message = TextFormat.RED + "You left hell and went to heaven!";

        player.dataPacket(packet);
        return true;
    }
}

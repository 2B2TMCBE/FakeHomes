package dev.kazuk.fakehomes.commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.utils.TextFormat;

public class SetHomeCommand extends Command {

    public SetHomeCommand() {
        super("sethome", "Set your home");
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{
                CommandParameter.newType("name", false, CommandParamType.STRING)
        });
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(TextFormat.RED + "You can only run this command as a player!");
            return true;
        }

        if (args.length <= 0) {
            sender.sendMessage(TextFormat.RED + "The home name can't be empty!");
            return true;
        }

        sender.sendMessage(TextFormat.RED + "You can't set your home in hell, you need to go to heaven first!");
        return true;
    }
}

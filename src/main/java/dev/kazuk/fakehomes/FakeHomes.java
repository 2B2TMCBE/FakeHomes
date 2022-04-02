package dev.kazuk.fakehomes;

import cn.nukkit.plugin.PluginBase;
import dev.kazuk.fakehomes.commands.HomeCommand;
import dev.kazuk.fakehomes.commands.SetHomeCommand;

public class FakeHomes extends PluginBase {

    @Override
    public void onEnable() {
        getServer().getCommandMap().register("home", new HomeCommand());
        getServer().getCommandMap().register("sethome", new SetHomeCommand());
    }
}

package CopperOxidationPlugin;


import CopperOxidationPlugin.commands.CommandGetOxidationStick;
import CopperOxidationPlugin.listeners.PlayerInteractListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class CopperOxidation extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin has been enabled!");
        getLogger().info(" ____ ___  ____  _      _    ____ ");
        getLogger().info("/  _ \\\\  \\/\\  \\/\\     / \\  /  _ \\");
        getLogger().info("| / \\| \\  /  \\ /_____ | |  | / \\|");
        getLogger().info("| \\_/| /  \\  / \\____\\| |__| \\_/|");
        getLogger().info("\\____//__/\\/_/        \\_/\\/\\____/");

        // Set up command executor
        if (this.getCommand("getoxidationstick") != null) {
            Objects.requireNonNull(this.getCommand("getoxidationstick")).setExecutor(new CommandGetOxidationStick());
        }

        // Register event listener
        getServer().getPluginManager().registerEvents(new PlayerInteractListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled.");
    }
}

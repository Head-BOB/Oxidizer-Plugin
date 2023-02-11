package CopperOxidationPlugin.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class CommandGetOxidationStick implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player player) {
            ItemStack stick = new ItemStack(Material.STICK);
            stick.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
            player.getInventory().addItem(stick);
            player.sendMessage("You received an oxidation stick!");
            return true;
        } else {
            sender.sendMessage("Only players can use this command.");
            return false;
        }
    }
}

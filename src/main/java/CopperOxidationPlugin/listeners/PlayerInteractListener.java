package CopperOxidationPlugin.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        // Check if player right-clicked a copper block with an enchanted stick
        if (event.getAction().name().contains("RIGHT_CLICK")
                && item != null
                && item.getType() == Material.STICK
                && item.getEnchantments().containsKey(Enchantment.DURABILITY)
                && event.getClickedBlock() != null
                && event.getClickedBlock().getType() == Material.COPPER_BLOCK) {
            event.setCancelled(true); // Prevent stick from being consumed
            event.getClickedBlock().setType(Material.OXIDIZED_COPPER);

            // Update stick durability
            ItemMeta meta = item.getItemMeta();
            if (meta instanceof Damageable durability) {
                durability.setDamage(durability.getDamage() + 1);
                item.setItemMeta(meta);

                if (durability.getDamage() >= item.getType().getMaxDurability()) {
                    // Stick broke, remove from inventory
                    player.getInventory().remove(item);
                }
            }
        }
    }

}

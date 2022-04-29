import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {

        Player player = event.getWhoClicked().getKiller();
        String inventoryTitle = event.getClickedInventory().getViewers().get(0).getOpenInventory().getTitle();

        switch (inventoryTitle) {
            case "Tic Tac Toe":
                ItemStack currentItem = event.getCurrentItem();
                event.setCancelled(true);
                if (currentItem.getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {

                }

                break;
            default:
                break;

        }

    }
}

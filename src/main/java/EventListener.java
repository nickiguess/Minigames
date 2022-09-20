import TicTacToe.TicTacToe;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {

    public EventListener() {
    }


    @EventHandler
    public void onPlayerClick(InventoryClickEvent event) {

        Player player = event.getWhoClicked().getKiller();
        Inventory inventory = event.getClickedInventory();
        String inventoryTitle = inventory.getViewers().get(0).getOpenInventory().getTitle();
        ItemStack currentItem = event.getCurrentItem();
        int currentSlot = event.getSlot();

        switch (inventoryTitle) {
            case "Tic Tac Toe":
                event.setCancelled(true);
                TicTacToe tictactoe = new TicTacToe();
                tictactoe.TicTacToeClick(inventory, currentItem, currentSlot, player);
                break;
            default:
                break;

        }

    }
}

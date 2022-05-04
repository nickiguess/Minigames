import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
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

    public void TicTacToeClick(Inventory inventory, ItemStack currentItem, int currentSlot) {
        if (currentItem.getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {

        } else {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            NBTItem nbti = new NBTItem(playerHead);
            NBTCompound skull = nbti.addCompound("SkullOwner");
            skull.setString("Name", "Blank");
            skull.setString("Id", "fce0323d-7f50-4317-9720-5f6b14cf78ea");
            NBTListCompound texture = skull.addCompound("Properties").getCompoundList("textures").addCompound();
            texture.setString("Signature", "XpRfRz6/vXE6ip7/vq+40H6W70GFB0yjG6k8hG4pmFdnJFR+VQhslE0gXX/i0OAGThcAVSIT+/W1685wUxNofAiy+EhcxGNxNSJkYfOgXEVHTCuugpr+EQCUBI6muHDKms3PqY8ECxdbFTUEuWxdeiJsGt9VjHZMmUukkGhk0IobjQS3hjQ44FiT1tXuUU86oAxqjlKFpXG/iXtpcoXa33IObSI1S3gCKzVPOkMGlHZqRqKKElB54I2Qo4g5CJ+noudIDTzxPFwEEM6XrbM0YBi+SOdRvTbmrlkWF+ndzVWEINoEf++2hkO0gfeCqFqSMHuklMSgeNr/YtFZC5ShJRRv7zbyNF33jZ5DYNVR+KAK9iLO6prZhCVUkZxb1/BjOze6aN7kyN01u3nurKX6n3yQsoQQ0anDW6gNLKzO/mCvoCEvgecjaOQarktl/xYtD4YvdTTlnAlv2bfcXUtc++3UPIUbzf/jpf2g2wf6BGomzFteyPDu4USjBdpeWMBz9PxVzlVpDAtBYClFH/PFEQHMDtL5Q+VxUPu52XlzlUreMHpLT9EL92xwCAwVBBhrarQQWuLjAQXkp3oBdw6hlX6Fj0AafMJuGkFrYzcD7nNr61l9ErZmTWnqTxkJWZfZxmYBsFgV35SKc8rkRSHBNjcdKJZVN4GA+ZQH5B55mi4=");
            texture.setString("Value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDExZGUxY2FkYjJhZGU2MTE0OWU1ZGVkMWJkODg1ZWRmMGRmNjI1OTI1NWIzM2I1ODdhOTZmOTgzYjJhMSJ9fX0=");
            playerHead = nbti.getItem();

            ItemStack aiHead = new ItemStack(Material.PLAYER_HEAD, 1);
            NBTItem nbtiAI = new NBTItem(playerHead);
            NBTCompound skullAI = nbtiAI.addCompound("SkullOwner");
            skullAI.setString("Name", "Blank");
            skullAI.setString("Id", "fce0323d-7f50-4317-9720-5f6b14cf78ea");
            NBTListCompound textureAI = skullAI.addCompound("Properties").getCompoundList("textures").addCompound();
            textureAI.setString("Signature", "XpRfRz6/vXE6ip7/vq+40H6W70GFB0yjG6k8hG4pmFdnJFR+VQhslE0gXX/i0OAGThcAVSIT+/W1685wUxNofAiy+EhcxGNxNSJkYfOgXEVHTCuugpr+EQCUBI6muHDKms3PqY8ECxdbFTUEuWxdeiJsGt9VjHZMmUukkGhk0IobjQS3hjQ44FiT1tXuUU86oAxqjlKFpXG/iXtpcoXa33IObSI1S3gCKzVPOkMGlHZqRqKKElB54I2Qo4g5CJ+noudIDTzxPFwEEM6XrbM0YBi+SOdRvTbmrlkWF+ndzVWEINoEf++2hkO0gfeCqFqSMHuklMSgeNr/YtFZC5ShJRRv7zbyNF33jZ5DYNVR+KAK9iLO6prZhCVUkZxb1/BjOze6aN7kyN01u3nurKX6n3yQsoQQ0anDW6gNLKzO/mCvoCEvgecjaOQarktl/xYtD4YvdTTlnAlv2bfcXUtc++3UPIUbzf/jpf2g2wf6BGomzFteyPDu4USjBdpeWMBz9PxVzlVpDAtBYClFH/PFEQHMDtL5Q+VxUPu52XlzlUreMHpLT9EL92xwCAwVBBhrarQQWuLjAQXkp3oBdw6hlX6Fj0AafMJuGkFrYzcD7nNr61l9ErZmTWnqTxkJWZfZxmYBsFgV35SKc8rkRSHBNjcdKJZVN4GA+ZQH5B55mi4=");
            textureAI.setString("Value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDExZGUxY2FkYjJhZGU2MTE0OWU1ZGVkMWJkODg1ZWRmMGRmNjI1OTI1NWIzM2I1ODdhOTZmOTgzYjJhMSJ9fX0=");
            aiHead = nbtiAI.getItem();

            inventory.setItem(currentSlot, playerHead);
        }
    }

    public boolean CheckVictoryTicTacToe(Inventory inventory, ItemStack playerHead, ItemStack aiHead) {

        ItemStack playerWinHead = new ItemStack(Material.PLAYER_HEAD, 1);
        NBTItem nbtiPlayerWin = new NBTItem(playerHead);
        NBTCompound skullPlayerWin = nbtiPlayerWin.addCompound("SkullOwner");
        skullPlayerWin.setString("Name", "Blank");
        skullPlayerWin.setString("Id", "fce0323d-7f50-4317-9720-5f6b14cf78ea");
        NBTListCompound texturePlayerWin = skullPlayerWin.addCompound("Properties").getCompoundList("textures").addCompound();
        texturePlayerWin.setString("Signature", "XpRfRz6/vXE6ip7/vq+40H6W70GFB0yjG6k8hG4pmFdnJFR+VQhslE0gXX/i0OAGThcAVSIT+/W1685wUxNofAiy+EhcxGNxNSJkYfOgXEVHTCuugpr+EQCUBI6muHDKms3PqY8ECxdbFTUEuWxdeiJsGt9VjHZMmUukkGhk0IobjQS3hjQ44FiT1tXuUU86oAxqjlKFpXG/iXtpcoXa33IObSI1S3gCKzVPOkMGlHZqRqKKElB54I2Qo4g5CJ+noudIDTzxPFwEEM6XrbM0YBi+SOdRvTbmrlkWF+ndzVWEINoEf++2hkO0gfeCqFqSMHuklMSgeNr/YtFZC5ShJRRv7zbyNF33jZ5DYNVR+KAK9iLO6prZhCVUkZxb1/BjOze6aN7kyN01u3nurKX6n3yQsoQQ0anDW6gNLKzO/mCvoCEvgecjaOQarktl/xYtD4YvdTTlnAlv2bfcXUtc++3UPIUbzf/jpf2g2wf6BGomzFteyPDu4USjBdpeWMBz9PxVzlVpDAtBYClFH/PFEQHMDtL5Q+VxUPu52XlzlUreMHpLT9EL92xwCAwVBBhrarQQWuLjAQXkp3oBdw6hlX6Fj0AafMJuGkFrYzcD7nNr61l9ErZmTWnqTxkJWZfZxmYBsFgV35SKc8rkRSHBNjcdKJZVN4GA+ZQH5B55mi4=");
        texturePlayerWin.setString("Value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDExZGUxY2FkYjJhZGU2MTE0OWU1ZGVkMWJkODg1ZWRmMGRmNjI1OTI1NWIzM2I1ODdhOTZmOTgzYjJhMSJ9fX0=");
        playerWinHead = nbtiPlayerWin.getItem();

        ItemStack aiWinHead = new ItemStack(Material.PLAYER_HEAD, 1);
        NBTItem nbtiAIWin = new NBTItem(playerHead);
        NBTCompound skullAIWin = nbtiAIWin.addCompound("SkullOwner");
        skullAIWin.setString("Name", "Blank");
        skullAIWin.setString("Id", "fce0323d-7f50-4317-9720-5f6b14cf78ea");
        NBTListCompound textureAIWin = skullAIWin.addCompound("Properties").getCompoundList("textures").addCompound();
        textureAIWin.setString("Signature", "XpRfRz6/vXE6ip7/vq+40H6W70GFB0yjG6k8hG4pmFdnJFR+VQhslE0gXX/i0OAGThcAVSIT+/W1685wUxNofAiy+EhcxGNxNSJkYfOgXEVHTCuugpr+EQCUBI6muHDKms3PqY8ECxdbFTUEuWxdeiJsGt9VjHZMmUukkGhk0IobjQS3hjQ44FiT1tXuUU86oAxqjlKFpXG/iXtpcoXa33IObSI1S3gCKzVPOkMGlHZqRqKKElB54I2Qo4g5CJ+noudIDTzxPFwEEM6XrbM0YBi+SOdRvTbmrlkWF+ndzVWEINoEf++2hkO0gfeCqFqSMHuklMSgeNr/YtFZC5ShJRRv7zbyNF33jZ5DYNVR+KAK9iLO6prZhCVUkZxb1/BjOze6aN7kyN01u3nurKX6n3yQsoQQ0anDW6gNLKzO/mCvoCEvgecjaOQarktl/xYtD4YvdTTlnAlv2bfcXUtc++3UPIUbzf/jpf2g2wf6BGomzFteyPDu4USjBdpeWMBz9PxVzlVpDAtBYClFH/PFEQHMDtL5Q+VxUPu52XlzlUreMHpLT9EL92xwCAwVBBhrarQQWuLjAQXkp3oBdw6hlX6Fj0AafMJuGkFrYzcD7nNr61l9ErZmTWnqTxkJWZfZxmYBsFgV35SKc8rkRSHBNjcdKJZVN4GA+ZQH5B55mi4=");
        textureAIWin.setString("Value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDExZGUxY2FkYjJhZGU2MTE0OWU1ZGVkMWJkODg1ZWRmMGRmNjI1OTI1NWIzM2I1ODdhOTZmOTgzYjJhMSJ9fX0=");
        aiWinHead = nbtiAIWin.getItem();

        int topLeft = 0;
        int midLeft = 0;
        int bottomLeft = 0;
        int topMid = 0;
        int center = 0;
        int bottomMid = 0;
        int topRight = 0;
        int midRight = 0;
        int bottomRight = 0;

        if (inventory.getItem(12).equals(playerHead)) {
            topLeft = 1;
        } else if(inventory.getItem(12).equals(aiHead)) {
            topLeft = 2;
        }

        if (inventory.getItem(13).equals(playerHead)) {
            topMid = 1;
        } else if(inventory.getItem(13).equals(aiHead)) {
            topMid = 2;
        }

        if (inventory.getItem(14).equals(playerHead)) {
            topRight = 1;
        } else if(inventory.getItem(14).equals(aiHead)) {
            topRight = 2;
        }

        if (inventory.getItem(21).equals(playerHead)) {
            midLeft = 1;
        } else if(inventory.getItem(21).equals(aiHead)) {
            midLeft = 2;
        }

        if (inventory.getItem(22).equals(playerHead)) {
            center = 1;
        } else if(inventory.getItem(22).equals(aiHead)) {
            center = 2;
        }

        if (inventory.getItem(23).equals(playerHead)) {
            midRight = 1;
        } else if(inventory.getItem(23).equals(aiHead)) {
            midRight = 2;
        }

        if (inventory.getItem(30).equals(playerHead)) {
            bottomLeft = 1;
        } else if(inventory.getItem(30).equals(aiHead)) {
            bottomLeft = 2;
        }

        if (inventory.getItem(31).equals(playerHead)) {
            bottomMid = 1;
        } else if(inventory.getItem(31).equals(aiHead)) {
            bottomMid = 2;
        }

        if (inventory.getItem(32).equals(playerHead)) {
            bottomRight = 1;
        } else if(inventory.getItem(32).equals(aiHead)) {
            bottomRight = 2;
        }

        int topLine = topLeft + topMid + topRight;
        int midLine = midLeft + center + midRight;
        int bottomLine = bottomLeft + bottomMid + bottomRight;
        int leftColumn = topLeft + midLeft + bottomLeft;
        int midColumn = topMid + center + bottomMid;
        int rightColumn = topRight + midRight + bottomRight;
        int rightDiagonal = topLeft + center + bottomRight;
        int leftDiagonal = topRight + center + bottomLeft;



        return true;
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
                TicTacToeClick(inventory, currentItem, currentSlot);
                break;
            default:
                break;

        }

    }
}

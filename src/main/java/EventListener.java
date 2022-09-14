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

    protected int gameStart = 0;

    protected TicTacToe tictactoe;

    public EventListener() {
    }

    public void TicTacToeClick(Inventory inventory, ItemStack currentItem, int currentSlot) {

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

        if (currentItem.getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {


        } else if (!currentItem.equals(playerHead) && !currentItem.equals(aiHead)){


        } else {

            tictactoe.playerRound = SetTicTacToe(tictactoe.playerRound, inventory, currentSlot, playerHead, aiHead);

            if (CheckVictoryTicTacToe(inventory, playerHead, aiHead)) {
                Bukkit.broadcastMessage("§4§l§o[§c§L§oMinigames§4§l§o] §c§l§o» §e§L§oYou won!");
            }
        }
    }

    public int SetTicTacToe(int playerRound, Inventory inventory, int currentSlot, ItemStack playerHead, ItemStack aiHead) {
        switch (playerRound) {
            case 0:
                inventory.setItem(currentSlot, playerHead);
                playerRound = 1;
                break;
            case 1:
                inventory.setItem(currentSlot, aiHead);
                playerRound = 0;
                break;
        }

        return playerRound;
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

        if (inventory.getItem(12).equals(playerHead)) {
            tictactoe.topLeft = 5;
        } else if(inventory.getItem(12).equals(aiHead)) {
            tictactoe.topLeft = 10;
        }

        if (inventory.getItem(13).equals(playerHead)) {
            tictactoe.topMid = 5;
        } else if(inventory.getItem(13).equals(aiHead)) {
            tictactoe.topMid = 10;
        }

        if (inventory.getItem(14).equals(playerHead)) {
            tictactoe.topRight = 5;
        } else if(inventory.getItem(14).equals(aiHead)) {
            tictactoe.topRight = 10;
        }

        if (inventory.getItem(21).equals(playerHead)) {
            tictactoe.midLeft = 5;
        } else if(inventory.getItem(21).equals(aiHead)) {
            tictactoe.midLeft = 10;
        }

        if (inventory.getItem(22).equals(playerHead)) {
            tictactoe.center = 5;
        } else if(inventory.getItem(22).equals(aiHead)) {
            tictactoe.center = 10;
        }

        if (inventory.getItem(23).equals(playerHead)) {
            tictactoe.midRight = 5;
        } else if(inventory.getItem(23).equals(aiHead)) {
            tictactoe.midRight = 10;
        }

        if (inventory.getItem(30).equals(playerHead)) {
            tictactoe.bottomLeft = 5;
        } else if(inventory.getItem(30).equals(aiHead)) {
            tictactoe.bottomLeft = 10;
        }

        if (inventory.getItem(31).equals(playerHead)) {
            tictactoe.bottomMid = 5;
        } else if(inventory.getItem(31).equals(aiHead)) {
            tictactoe.bottomMid = 10;
        }

        if (inventory.getItem(32).equals(playerHead)) {
            tictactoe.bottomRight = 5;
        } else if(inventory.getItem(32).equals(aiHead)) {
            tictactoe.bottomRight = 10;
        }

        int topLine = tictactoe.topLeft + tictactoe.topMid + tictactoe.topRight;
        int midLine = tictactoe.midLeft + tictactoe.center + tictactoe.midRight;
        int bottomLine = tictactoe.bottomLeft + tictactoe.bottomMid + tictactoe.bottomRight;
        int leftColumn = tictactoe.topLeft + tictactoe.midLeft + tictactoe.bottomLeft;
        int midColumn = tictactoe.topMid + tictactoe.center + tictactoe.bottomMid;
        int rightColumn = tictactoe.topRight + tictactoe.midRight + tictactoe.bottomRight;
        int rightDiagonal = tictactoe.topLeft + tictactoe.center + tictactoe.bottomRight;
        int leftDiagonal = tictactoe.topRight + tictactoe.center + tictactoe.bottomLeft;

        if (topLine % 5 == 0) {
            return true;
        }

        if (midLine % 5 == 0) {
            return true;
        }

        if (bottomLine % 5 == 0) {
            return true;
        }

        if (leftColumn % 5 == 0) {
            return true;
        }

        if (midColumn % 5 == 0) {
            return true;
        }

        if (rightColumn % 5 == 0) {
            return true;
        }

        if (rightDiagonal % 5 == 0) {
            return true;
        }

        if (leftDiagonal % 5 == 0) {
            return true;
        }

        return false;
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
                if (gameStart == 0) {
                    tictactoe = new TicTacToe(player);
                    gameStart = 1;
                }
                TicTacToeClick(inventory, currentItem, currentSlot);
                break;
            default:
                break;

        }

    }
}

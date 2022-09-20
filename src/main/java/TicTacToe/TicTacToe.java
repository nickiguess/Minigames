package TicTacToe;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    protected static int size = 45;
    protected static String name = "Tic Tac Toe";
    protected Inventory gameInventory;
    protected int gameStart = 0;

    public int topLeft = 10;
    public int midLeft = 10;
    public int bottomLeft = 10;
    public int topMid = 10;
    public int center = 10;
    public int bottomMid = 10;
    public int topRight = 10;
    public int midRight = 10;
    public int bottomRight = 10;

    String playerName1;
    String playerName2;

    public int playerRound;

    public TicTacToe() {

    }

    public void TicTacToeStart(Player player, String playerNameOne, String playerNameTwo) {

        playerName1 = playerNameOne;
        playerName2 = playerNameTwo;

        gameInventory = Bukkit.createInventory(player, size, name);

        gameInventory = fillInventory(gameInventory);

        player.openInventory(gameInventory);
        Bukkit.getPlayer(playerName2).openInventory(gameInventory);

        playerRound = 0;

    }

    // This Method is used when you click an object during the tictactoe game
    public void TicTacToeClick(Inventory inventory, ItemStack currentItem, int currentSlot, Player player) {

        // Creates the two items needed for visual distinction
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

        // Checks which item you clicked, to see if it needs to set anything or not
        // If the item is either the glass panes that are used for decoration or the placed heads, it does nothing
        // Otherwise, it will execute the following code
        if (currentItem.getType().equals(Material.GRAY_STAINED_GLASS_PANE)) {


        } else if (currentItem.equals(playerHead) || currentItem.equals(aiHead)){

        } else {

            // This code calls a Method that's used to update the game board and also updates the playerturn
            playerRound = SetTicTacToe(playerRound, inventory, currentSlot, playerHead, aiHead, player);

            // Afterwards, we check if the player has won by calling the Method that checks for that
            switch (CheckVictoryTicTacToe(inventory, playerHead, aiHead)) {
                case "player1":
                    Bukkit.getPlayer(playerName1).closeInventory();
                    Bukkit.getPlayer(playerName2).closeInventory();
                    Bukkit.broadcastMessage("§4§l§o[§c§L§oMinigames§4§l§o] §c§l§o» §e§L§o" + playerName1 +  "You won!");
                    break;
                case "player2":
                    Bukkit.getPlayer(playerName1).closeInventory();
                    Bukkit.getPlayer(playerName2).closeInventory();
                    Bukkit.broadcastMessage("§4§l§o[§c§L§oMinigames§4§l§o] §c§l§o» §e§L§o" + playerName2 +  "You won!");
                    break;
                default:
                    break;
            }
        }
    }

    // This Method is used to update the game board
    public int SetTicTacToe(int playerRound, Inventory inventory, int currentSlot, ItemStack playerHead, ItemStack aiHead, Player player) {

        // Checks which round it is to know which head should be placed, places it and then changes the round
        if (playerRound == 0 && player.getName().equals(playerName1)) {

            inventory.setItem(currentSlot, playerHead);
            playerRound = 1;
        } else if (playerRound == 1 && player.getName().equals(playerName2)) {

            inventory.setItem(currentSlot, playerHead);
            playerRound = 0;
        }

        // Returns the current round to update it
        return playerRound;
    }

    // This Method is used to check if the game board is in a winning state or not
    public String CheckVictoryTicTacToe(Inventory inventory, ItemStack playerHead, ItemStack aiHead) {

        /*
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
         */

        // These if statements check every single game tile and assing a value to each one based on which head is there
        // The value 1 is used for player 1's tiles
        // The value 0 is used for player 2's tiles


        if (inventory.getItem(12).equals(playerHead)) {
            topLeft = 1;
        } else if(inventory.getItem(12).equals(aiHead)) {
            topLeft = 0;
        }

        if (inventory.getItem(13).equals(playerHead)) {
            topMid = 1;
        } else if(inventory.getItem(13).equals(aiHead)) {
            topMid = 0;
        }

        if (inventory.getItem(14).equals(playerHead)) {
            topRight = 1;
        } else if(inventory.getItem(14).equals(aiHead)) {
            topRight = 0;
        }

        if (inventory.getItem(21).equals(playerHead)) {
            midLeft = 1;
        } else if(inventory.getItem(21).equals(aiHead)) {
            midLeft = 0;
        }

        if (inventory.getItem(22).equals(playerHead)) {
            center = 1;
        } else if(inventory.getItem(22).equals(aiHead)) {
            center = 0;
        }

        if (inventory.getItem(23).equals(playerHead)) {
            midRight = 1;
        } else if(inventory.getItem(23).equals(aiHead)) {
            midRight = 0;
        }

        if (inventory.getItem(30).equals(playerHead)) {
            bottomLeft = 1;
        } else if(inventory.getItem(30).equals(aiHead)) {
            bottomLeft = 0;
        }

        if (inventory.getItem(31).equals(playerHead)) {
            bottomMid = 1;
        } else if(inventory.getItem(31).equals(aiHead)) {
            bottomMid = 0;
        }

        if (inventory.getItem(32).equals(playerHead)) {
            bottomRight = 1;
        } else if(inventory.getItem(32).equals(aiHead)) {
            bottomRight = 0;
        }

        // We then add all the individual tiles together in every single row, column and diagonal
        int topLine = topLeft + topMid + topRight;
        int midLine = midLeft + center + midRight;
        int bottomLine = bottomLeft + bottomMid + bottomRight;
        int leftColumn = topLeft + midLeft + bottomLeft;
        int midColumn = topMid + center + bottomMid;
        int rightColumn = topRight + midRight + bottomRight;
        int rightDiagonal = topLeft + center + bottomRight;
        int leftDiagonal = topRight + center + bottomLeft;

        // And we check if any of them have a winning combination

        /*
          This is a more in-depth explanation on how the whole winning system works

          Every tile, when we call and create the tictactoe object, is assigned a value of 10
          Then, every time we check if someone has one, we update every tile with a value, either 1 or 0

          We then add up all the values in the vary combination of tiles we can then just check if there's any value
          that equals either to 3 or 0, and then return the victory accordingly

        */
        if (topLine == 3) {
            return "player1";
        } else if (topLine == 0) {
            return "player2";
        }

        if (midLine == 3) {
            return "player1";
        } else if (midLine == 0) {
            return "player2";
        }

        if (bottomLine == 3) {
            return "player1";
        } else if (bottomLine == 0) {
            return "player2";
        }

        if (rightColumn == 3) {
            return "player1";
        } else if (rightColumn == 0) {
            return "player2";
        }

        if (midColumn == 3) {
            return "player1";
        } else if (midColumn == 0) {
            return "player2";
        }

        if (leftColumn == 3) {
            return "player1";
        } else if (leftColumn == 0) {
            return "player2";
        }

        if (rightDiagonal == 3) {
            return "player1";
        } else if (rightDiagonal == 0) {
            return "player2";
        }

        if (leftDiagonal == 3) {
            return "player1";
        } else if (leftDiagonal == 0) {
            return "player2";
        }

        return "false";
    }

    public Inventory fillInventory(Inventory gameInventory) {

        ItemStack emptySpace = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta emptyMeta = emptySpace.getItemMeta();
        emptyMeta.setDisplayName("§0");
        emptySpace.setItemMeta(emptyMeta);

        ItemStack baseHead = new ItemStack(Material.PLAYER_HEAD, 1);
        NBTItem nbti = new NBTItem(baseHead);
        NBTCompound skull = nbti.addCompound("SkullOwner");
        skull.setString("Name", "Blank");
        skull.setString("Id", "fce0323d-7f50-4317-9720-5f6b14cf78ea");
        NBTListCompound texture = skull.addCompound("Properties").getCompoundList("textures").addCompound();
        texture.setString("Signature", "XpRfRz6/vXE6ip7/vq+40H6W70GFB0yjG6k8hG4pmFdnJFR+VQhslE0gXX/i0OAGThcAVSIT+/W1685wUxNofAiy+EhcxGNxNSJkYfOgXEVHTCuugpr+EQCUBI6muHDKms3PqY8ECxdbFTUEuWxdeiJsGt9VjHZMmUukkGhk0IobjQS3hjQ44FiT1tXuUU86oAxqjlKFpXG/iXtpcoXa33IObSI1S3gCKzVPOkMGlHZqRqKKElB54I2Qo4g5CJ+noudIDTzxPFwEEM6XrbM0YBi+SOdRvTbmrlkWF+ndzVWEINoEf++2hkO0gfeCqFqSMHuklMSgeNr/YtFZC5ShJRRv7zbyNF33jZ5DYNVR+KAK9iLO6prZhCVUkZxb1/BjOze6aN7kyN01u3nurKX6n3yQsoQQ0anDW6gNLKzO/mCvoCEvgecjaOQarktl/xYtD4YvdTTlnAlv2bfcXUtc++3UPIUbzf/jpf2g2wf6BGomzFteyPDu4USjBdpeWMBz9PxVzlVpDAtBYClFH/PFEQHMDtL5Q+VxUPu52XlzlUreMHpLT9EL92xwCAwVBBhrarQQWuLjAQXkp3oBdw6hlX6Fj0AafMJuGkFrYzcD7nNr61l9ErZmTWnqTxkJWZfZxmYBsFgV35SKc8rkRSHBNjcdKJZVN4GA+ZQH5B55mi4=");
        texture.setString("Value", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWRiNTMyYjVjY2VkNDZiNGI1MzVlY2UxNmVjZWQ3YmJjNWNhYzU1NTk0ZDYxZThiOGY4ZWFjNDI5OWM5ZmMifX19");
        baseHead = nbti.getItem();

        for (int i = 0; i < 45; i++) {
            switch (i) {
                case 12:
                case 13:
                case 14:
                case 21:
                case 22:
                case 23:
                case 30:
                case 31:
                case 32:
                    gameInventory.setItem(i, baseHead);
                    break;
                default:
                    gameInventory.setItem(i, emptySpace);
                    break;
            }
        }

        return gameInventory;
    }
}

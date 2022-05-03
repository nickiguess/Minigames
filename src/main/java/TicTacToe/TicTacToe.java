package TicTacToe;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTListCompound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    protected static int size = 45;
    protected static String name = "Tic Tac Toe";
    protected Inventory gameInventory;

    public TicTacToe(Player player) {

        gameInventory = Bukkit.createInventory(player, size, name);

        gameInventory = fillInventory(gameInventory);

        player.openInventory(gameInventory);

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

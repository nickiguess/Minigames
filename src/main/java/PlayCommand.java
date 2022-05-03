import TicTacToe.TicTacToe;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayCommand implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length != 0) {
                switch (args[0]) {
                    case "tictactoe":
                        TicTacToe ticTacToe = new TicTacToe(player);
                        break;
                    default:
                        Bukkit.broadcastMessage("§4§l§o[§c§L§oMinigames§4§l§o] §c§l§o» §e§L§oThis game does not exist!");
                }
            }
            return true;
        } else {
            Bukkit.getLogger().warning("This command can only be used by a player");
            return false;
        }
    }
}

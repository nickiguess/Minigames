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
                        if (args[1] != null) {
                            if (Bukkit.getPlayer(args[1]) != null) {
                                TicTacToe ticTacToe = new TicTacToe();
                                ticTacToe.TicTacToeStart(player, sender.getName(), args[1]);
                                break;
                            } else {
                                Bukkit.broadcastMessage("§4§l§o[§c§L§oMinigames§4§l§o] §c§l§o» §e§L§oThat player is not online!");
                            }
                        } else {
                            Bukkit.broadcastMessage("§4§l§o[§c§L§oMinigames§4§l§o] §c§l§o» §e§L§oYou must challenge another player!");
                        }
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

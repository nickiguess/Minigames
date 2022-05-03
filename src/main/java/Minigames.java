import org.bukkit.plugin.java.JavaPlugin;

public class Minigames extends JavaPlugin {

    static private Minigames instance;

    // Fired when plugin is enabled
    @Override
    public void onEnable() {
        instance = this;

        this.getCommand("play").setExecutor(new PlayCommand());

        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }

    public static Minigames getPlugin() {
        return instance;
    }
}

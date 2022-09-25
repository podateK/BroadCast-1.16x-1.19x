package store.techcode;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main main;

    @Override
    public void onEnable() {
    main = this;

    new BroadCast(this);

    }
    public static Main getMain() {
        return main;
    }
    @Override
    public void onDisable() {

    }
}

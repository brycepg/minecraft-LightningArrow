package me.rahazan.lightningarrow;
import java.util.logging.Logger;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
/**
 * @author Guido Z (Rahazan) 
 *
 */
public class LightningArrow extends JavaPlugin {
	
	private final LightningArrowEntityListener entityListener = new LightningArrowEntityListener(this);
	
	Logger log = Logger.getLogger("Minecraft"); //The logger that is logged to by this plugin.
	/* (non-Javadoc)
	 * @see org.bukkit.plugin.Plugin#onEnable()
	 */
	@Override
    public void onEnable() {
		
		
		getConfig().options().copyDefaults(true); //Copies the contents of config.yml which is included in the src folder <- .
		getConfig().options().header("The node below sets the probability of \nlightning occuring on arrow hit."); //Adds header to the config.
		saveConfig(); //Saves the config.
		
        getServer().getPluginManager().registerEvent(Event.Type.PROJECTILE_HIT, entityListener, Event.Priority.Normal, this);
        PluginDescriptionFile pdfFile = this.getDescription(); //Declaration of the pdfFile which represents the plugin.yml file
		log.info("[" + pdfFile.getName() + "] (By Rahazan) - v" + pdfFile.getVersion() + " loaded."); //Plugin enabled message.
    }

    /* (non-Javadoc)
     * @see org.bukkit.plugin.Plugin#onDisable()
     */
    @Override
    public void onDisable() {
    	PluginDescriptionFile pdfFile = this.getDescription(); //Declaration of the pdfFile which represents the plugin.yml file
		log.info("[" + pdfFile.getName() + "] (By Rahazan) - v" + pdfFile.getVersion() + " unloaded."); //Plugin disabled message.
    }
}

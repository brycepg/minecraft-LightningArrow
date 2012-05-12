package me.rahazan.lightningarrow;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.ProjectileHitEvent;

/**
 * @author Guido Z (Rahazan) 
 *
 */
class LightningArrowEntityListener extends EntityListener {
	Random randomGenerator = new Random();
	
	/**
	 *  Field that points to the plugin.
	 */
	public static LightningArrow plugin; 
	
	/**
	 * Constructor for the EntityListener.
	 * @param instance the main plugin (LightningArrow class).
	 */
	public LightningArrowEntityListener(LightningArrow instance) {
        plugin = instance;
	}

	    /* (non-Javadoc)
	     * @see org.bukkit.event.entity.EntityListener#onProjectileHit(org.bukkit.event.entity.ProjectileHitEvent)
	     */
	    public void onProjectileHit(ProjectileHitEvent event) {
    	if(event.getEntity() instanceof Arrow){
    		//The projectile is an arrow.
    	  	Location loc = event.getEntity().getLocation();
    	  	Arrow arrow = (Arrow) event.getEntity();
    	  	
    	  	if (arrow.getShooter() instanceof Player) {
    	  		//Arrow was shot by a player.
    	  	  Player player = (Player)arrow.getShooter();
      	  		if (randomGenerator.nextInt(100) < plugin.getConfig().getInt("ChanceOfLighting", 10) && player.hasPermission("LightningArrow.use")){
      	  			//Lucky player that has permission.
      	  			event.getEntity().getWorld().strikeLightning(loc);
      	  			}
    	  	}
    	}
    }
}

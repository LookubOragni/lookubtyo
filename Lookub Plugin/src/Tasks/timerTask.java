package Tasks;

import org.bukkit.scheduler.BukkitRunnable;

import mainPackage.commands.CreeperSpawn;

public class timerTask extends BukkitRunnable {
	
	public int timer = 5;
	public boolean can02 = true;
	
	@Override
	public void run() {
		
		System.out.println(timer);
		
		timer --;
		
		if(timer == 0) {
			System.out.println("aa");
			can02 = true;
			cancel();
		}

	}

}

package com.maria.feedeffect.listeners;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import com.maria.feedeffect.Main;
import com.maria.feedeffect.managers.FeedEffectManager;

public class FeedEvent implements Listener {

	protected Main main;

	private FileConfiguration config;

	private FeedEffectManager feedEffectManager;

	public FeedEvent(Main main) {
		this.main = main;

		Bukkit.getPluginManager().registerEvents(this, main);

		config = main.getConfig();

		feedEffectManager = main.getFeedEffectManager();
	}

	@EventHandler
	void feedChange(FoodLevelChangeEvent e) {
		if (!(e.getEntity() instanceof Player))
			return;

		Player p = (Player) e.getEntity();

		double levelRequired = config.getDouble("Fome necessaria") * 2;

		if (e.getFoodLevel() <= levelRequired)
			feedEffectManager.sendEffects(p);
	}

}

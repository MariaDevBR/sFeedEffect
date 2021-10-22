package com.maria.feedeffect.managers;

import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.maria.feedeffect.Main;

public class FeedEffectManager {

	protected Main main;

	private FileConfiguration config;

	public FeedEffectManager(Main main) {
		this.main = main;

		config = main.getConfig();
	}

	public void sendEffects(Player p) {
		List<String> effectsList = config.getStringList("Efeitos");

		for (String effects : effectsList) {
			PotionEffectType effectType = PotionEffectType.getByName(effects.split(":")[0]);
			int effectDuration = Integer.parseInt(effects.split(":")[1]);
			int effectLevel = Integer.parseInt(effects.split(":")[2]);

			p.addPotionEffect(new PotionEffect(effectType, effectDuration * 20, effectLevel));

		}
		if (config.getBoolean("Enviar mensagem"))
			p.sendMessage(config.getString("Mensagem").replace("&", "§"));
	}

}

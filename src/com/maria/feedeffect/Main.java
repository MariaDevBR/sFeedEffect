package com.maria.feedeffect;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.maria.feedeffect.listeners.FeedEvent;
import com.maria.feedeffect.managers.FeedEffectManager;

public class Main extends JavaPlugin {

	private FeedEffectManager feedEffectManager;

	@Override
	public void onEnable() {
		saveDefaultConfig();

		ConsoleCommandSender consoleMessage = Bukkit.getConsoleSender();
		consoleMessage.sendMessage("§6[" + getDescription().getName() + "] §fIniciado com sucesso");
		consoleMessage.sendMessage("§6[" + getDescription().getName() + "] §fEntre em meu Discord");
		consoleMessage.sendMessage("§6[" + getDescription().getName() + "] §fDiscord: §6https://discord.gg/ysQMPe5tPh");
		consoleMessage.sendMessage("§6[" + getDescription().getName() + "] §fCriado por §6Maria_BR");
		registerObjects();
		registerFunctions();
	}

	private void registerFunctions() {
		new FeedEvent(this);
	}

	private void registerObjects() {
		feedEffectManager = new FeedEffectManager(this);
	}

	public FeedEffectManager getFeedEffectManager() {
		return feedEffectManager;
	}

}

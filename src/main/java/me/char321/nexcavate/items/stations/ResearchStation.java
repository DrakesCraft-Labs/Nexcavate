package me.char321.nexcavate.items.stations;

import me.char321.nexcavate.Nexcavate;
import me.char321.nexcavate.gui.NEGUI;
import me.char321.nexcavate.research.progress.PlayerProgress;
import me.char321.nexcavate.slimefun.NEStructure;
import me.char321.nexcavate.structure.Structure;
import me.char321.nexcavate.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ResearchStation extends NEStructure implements Listener {
    private final int tier;

    public ResearchStation(ItemStack item, String id, Structure structure, int tier) {
        super(item, id, structure);
        this.tier = tier;
        Bukkit.getPluginManager().registerEvents(this, Nexcavate.instance());
    }

    @EventHandler
    public void interactListener(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) && e.getClickedBlock() != null && structure.getCenterPiece().isValid(e.getClickedBlock())) {
            if (structure.validate(e.getClickedBlock().getLocation())) {
                e.setCancelled(true);
                handleClick(e.getPlayer());
            }
        }
    }

    public void handleClick(Player player) {
        if (!PlayerProgress.get(player).hasCompletedTutorial()) {
            playTutorial(player);
        } else {
            NEGUI.openResearchScreen(player, tier);
        }
    }

    private void playTutorial(Player player) {
        PlayerProgress.get(player).setCompletedTutorial(true);

        Utils.runWithDelay(80L,
        () -> {
            player.playSound(player, Sound.AMBIENT_WARPED_FOREST_MOOD, 1, 1);
            player.playSound(player, Sound.AMBIENT_SOUL_SAND_VALLEY_MOOD, 1, 1);
            player.playSound(player, Sound.AMBIENT_CRIMSON_FOREST_MOOD, 1, 1);
            player.playSound(player, Sound.AMBIENT_NETHER_WASTES_MOOD, 1, 1);
            player.sendMessage(Utils.color("&dHas construido la &emesa de investigación&d. Notas una energía enorme subiendo desde lo hondo del Nether"));
        }, () -> {
            player.sendMessage(Utils.color("&dPara tu sorpresa, una voz misteriosa atraviesa el aire"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oLlevamos atrapados aquí demasiado tiempo..."));
        }, () -> {
            player.sendMessage(Utils.color("&dTe quedas desconcertado. &f&o¿Qué? &r&dHablas solo"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oAyúdanos, por favor. Te necesitamos para reconstruir la civilización que fuimos."));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oSupongo que ya habrás visto alguna de nuestras fortalezas en ruinas"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oFueron el hogar de una civilización muy avanzada."));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oCapaces de lograr cosas hoy impensables"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oTras el &kGreat Abcdefghi&7&o quedaron reducidas a ruinas"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oEsta especie, y toda su civilización, fue borrada del Nether"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oQuedan rastros en los &emuros&7&o de lo que sigue en pie, pero para su especie ya no hay vuelta atrás"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oLa única forma de devolverles su grandeza es una herramienta muy concreta, hecha con materiales que ellos nunca pudieron conseguir"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oUn &epico arqueológico&7&o, capaz de extraer piezas antiguas de los bloques que rodean las fortalezas piglin"));
        }, () -> {
            player.sendMessage(Utils.color("&dAntes de que te dé tiempo a preguntar nada, la voz se ha ido"));
        }, () -> {
            NEGUI.openResearchScreen(player, tier);
        }
        );
    }

    @Override
    public void postRegister() {
        Nexcavate.instance().getRegistry().getResearchStations().put(tier, this);
    }
}

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
            player.sendMessage(Utils.color("&dConstruir con éxito &eplataforma de investigación&d Sientes una enorme energía que emana de las profundidades del mundo inferior."));
        }, () -> {
            player.sendMessage(Utils.color("&dPara tu sorpresa, una voz misteriosa penetra en el aire."));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oHemos estado atrapados aquí por mucho tiempo...."));
        }, () -> {
            player.sendMessage(Utils.color("&dte confundes&f&oQué? &r&destás hablando contigo mismo"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oPor favor ayúdanos, te necesitamos para reconstruir nuestra una vez gran civilización.。"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oSeguro que has visto algunos de los restos de nuestra fortaleza."));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oAlguna vez fueron el hogar de civilizaciones altamente desarrolladas.。"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oCapaz de lograr cosas que ahora son inimaginables."));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oexistir&kGreat Abcdefghi&7&oPosteriormente se convirtieron en ruinas."));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oLa especie, junto con toda su civilización, fue borrada del inframundo."));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oAún existen algunos rastros en las estructuras restantes.&emuro&7&oen, pero no es recuperable para la especie"));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&oLa única forma de que esta civilización recree su grandeza es utilizar una herramienta especial, pero esta herramienta sólo puede fabricarse con materiales que no pueden obtener."));
        }, () -> {
            player.playSound(player, Sound.ENTITY_ZOMBIFIED_PIGLIN_DEATH, 1, 0.5f);
            player.sendMessage(Utils.color("&7&ouno&epico arqueológico&7&o, Puede extraer piezas antiguas de bloques alrededor de la Fortaleza Piglin."));
        }, () -> {
            player.sendMessage(Utils.color("&dAntes de que pudieras hacer alguna pregunta, la voz se había ido."));
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

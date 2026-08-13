package me.char321.nexcavate.items.misc;

import com.github.drakescraft_labs.slimefun4.core.handlers.BlockPlaceHandler;
import me.char321.nexcavate.slimefun.NEAssembly;
import me.char321.nexcavate.structure.Structure;
import me.char321.nexcavate.util.Utils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class CivilizationCore extends NEAssembly {
    public CivilizationCore(ItemStack item, String id, Structure assembly) {
        super(item, id, assembly);
    }

    @Override
    public void preRegister() {
        super.preRegister();

        addItemHandler(new BlockPlaceHandler(false) {
            @Override
            public void onPlayerPlace(@Nonnull BlockPlaceEvent e) {
                playCutscene(e.getPlayer());
            }
        });
    }

    private void playCutscene(Player player) {
        player.playSound(player, Sound.BLOCK_END_PORTAL_SPAWN, 1, 1);
        Utils.runWithDelay(80L,
                () -> {
                    player.sendMessage(Utils.color("&dHas colocado un núcleo de civilización"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&o¿Qué? ¿Quién me ha despertado?"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1, 0.5f);
                    player.sendMessage(Utils.color("&a&oEspera... ¿eso qué es?"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oDice así: &e" + player.getName() + ""));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oHan reconstruido... nuestra civilización. ¿Esos son nuestros constructores?"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1, 0.5f);
                    player.sendMessage(Utils.color("&a&o¿De dónde habrán sacado las piezas para construirlo?"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oTienen que haber venido de otro mundo"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1, 0.5f);
                    player.sendMessage(Utils.color("&a&o¿Ves? ¡Te dije que alguien vendría a salvarnos! ¡Lo sabía!"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oYa, claro. Solo han pasado unos 179.000 años desde la extinción."));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_ADMIRING_ITEM, 1, 0.5f);
                    player.sendMessage(Utils.color("&a&oBueno, aun así deberías agradecérselo a &e" + player.getName() + "&a&onos ha salvado"));
                }, () -> {
                    player.playSound(player, Sound.ENTITY_PIGLIN_RETREAT, 1, 0.5f);
                    player.sendMessage(Utils.color("&9&oPor supuesto. Me alegra que nuestra civilización siga en pie después de milenios."));
                }, () -> {

                }, () -> {
                    player.playSound(player, Sound.MUSIC_DISC_BLOCKS, 1, 1f);
                    player.sendMessage(Utils.color("&e&lFinal"));
                }, () -> {
                    player.sendMessage(Utils.color("&e&l¡Gracias por jugar!"));
                }
        );
    }
}

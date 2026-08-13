package me.char321.nexcavate.structure.piece;

import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItem;
import com.github.drakescraft_labs.slimefun4.utils.SlimefunUtils;
import me.char321.nexcavate.items.misc.ItemHolder;
import me.char321.nexcavate.util.Utils;
import com.github.drakescraft_labs.slimefun4.legacy.api.BlockStorage;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

public class ItemHolderStructurePiece implements StructurePiece {
    private ItemStack item;

    public ItemHolderStructurePiece(ItemStack item) {
        this.item = item;
    }

    @Override
    public boolean isValid(Block b) {
        SlimefunItem sfitem = BlockStorage.check(b);
        if (!(sfitem instanceof ItemHolder holder)) {
            return false;
        }

        ItemStack held = BlockStorage.getInventory(b).getItemInSlot(13);
        return SlimefunUtils.isItemSimilar(this.item, held, true, true);
    }

    @Override
    public ItemStack getDisplay() {
        ItemStack clone = item.clone();
        Utils.appendLore(clone, "", "&7Coloca aquí un soporte para objetos y mete dentro el objeto que quieras ensamblar ");
        return clone;
    }
}

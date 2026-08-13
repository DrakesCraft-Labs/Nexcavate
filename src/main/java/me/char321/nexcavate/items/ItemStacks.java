package me.char321.nexcavate.items;

import com.github.drakescraft_labs.slimefun4.api.items.SlimefunItemStack;
import com.github.drakescraft_labs.slimefun4.libraries.dough.items.CustomItemStack;
import com.github.drakescraft_labs.slimefun4.utils.LoreBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ItemStacks {
    public static final ItemStack RESEARCH_TABLE = new CustomItemStack(Material.CARTOGRAPHY_TABLE, "&eMesa de investigación", "&7Te permite investigar los objetos básicos");
    public static final ItemStack RESEARCH_LAB = new CustomItemStack(Material.FLETCHING_TABLE, "&eLaboratorio de investigación", "&7Te permite investigar los objetos avanzados");

    public static final ItemStack REDISCOVERY_PICKAXE = new SlimefunItemStack("NE_REDISCOVERY_PICKAXE", Material.WOODEN_PICKAXE, "&ePico arqueológico", im -> {
        im.setLore(List.of(ChatColor.GRAY + "Herramienta básica para extraer piezas antiguas"));
        im.addEnchant(Enchantment.UNBREAKING, 2, false);
        im.addEnchant(Enchantment.EFFICIENCY, 1, false);
    });
    public static final ItemStack PART_DRILL = new SlimefunItemStack("NE_PART_DRILL", Material.DIAMOND_PICKAXE, "&cTaladro arqueológico", im -> {
        im.setLore(List.of(ChatColor.GRAY + "Herramienta avanzada para extraer piezas antiguas"));
        im.addEnchant(Enchantment.UNBREAKING, 3, false);
        im.addEnchant(Enchantment.EFFICIENCY, 5, false);
        im.addEnchant(Enchantment.MENDING, 1, false);
    });

    public static final ItemStack BLACKSTONE_CAST = new SlimefunItemStack("NE_BLACKSTONE_CAST", Material.CAULDRON, "&eExtractora de piedra negra", "&7Extrae lava automáticamente", "&7Con energía, lo proyecta sin límite sobre la piedra negra", "&7Debe colocarse sobre una fuente de lava del Nether", "", LoreBuilder.powerPerSecond(24));
    public static final ItemStack PART_EXTRACTOR = new SlimefunItemStack("NE_PART_EXTRACTOR", Material.RED_NETHER_BRICKS, "&eExtractora de piezas", "&7Extrae piezas antiguas de la piedra negra despacio", "", "&7Debe colocarse en el Nether", "", LoreBuilder.powerPerSecond(12));
    public static final ItemStack PART_EXTRACTOR_2 = new SlimefunItemStack("NE_PART_EXTRACTOR_2", Material.CHISELED_NETHER_BRICKS, "&dExtractora de piezas avanzada", "&7Extrae piezas antiguas de la piedra negra más rápido", "", "&7Debe colocarse en el Nether", "", LoreBuilder.powerPerSecond(24));

    public static final ItemStack ITEM_HOLDER = new SlimefunItemStack("NE_ITEM_HOLDER", Material.CYAN_STAINED_GLASS, "&fSoporte para objetos", "&7Almacena algunos objetos", "&7El objeto del soporte se puede usar en la ensambladora");

    public static final ItemStack BASIC_ASSEMBLER = new CustomItemStack(Material.CHISELED_QUARTZ_BLOCK, "&eEnsambladora básica", "&7Ensambla bloques en un radio pequeño de 3x3x3");
    public static final ItemStack ADVANCED_ASSEMBLER = new CustomItemStack(Material.QUARTZ_PILLAR, "&dEnsambladora avanzada", "&7Ensambla bloques en un radio grande de 4x4x4", "&8Solo funciona en el Nether");

    public static final ItemStack ANCIENT_PART = new SlimefunItemStack("NE_ANCIENT_PART", Material.NETHER_BRICK, "&ePieza antigua", "&7Restos de una civilización antigua");
    public static final ItemStack UPGRADE_CORE = new SlimefunItemStack("NE_UPGRADE_CORE", Material.TARGET, "&eNúcleo de mejora antiguo", "&7Lo que dejó atrás una civilización avanzada");

    public static final ItemStack CIVILIZATION_CORE = new SlimefunItemStack("NE_CIVILIZATION_CORE", Material.CONDUIT, "&bNúcleo de civilización", "&dGuarda algo de la antigua civilización del Nether", "&dSirve para despertar a la civilización &kasdfg hijklmn");

    public static class Menu {
        public static final ItemStack BLACK = new CustomItemStack(Material.BLACK_STAINED_GLASS_PANE, " ");
    }
}

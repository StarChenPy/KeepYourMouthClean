package xyz.starsdust.keep_your_mouth_clean.world.item;

import net.minecraft.world.item.Item;
import xyz.starsdust.keep_your_mouth_clean.toolbox.RegistryTool;
import xyz.starsdust.keep_your_mouth_clean.world.item.toothbrush.RedstoneToothbrush;
import xyz.starsdust.keep_your_mouth_clean.world.item.toothbrush.Toothbrush;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/23
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class ModItems {
    public static final Item TOOTHBRUSH = RegistryTool.register(new Toothbrush(), "toothbrush");
    public static final Item REDSTONE_TOOTHBRUSH = RegistryTool.register(new RedstoneToothbrush(), "redstone_toothbrush");
    public static final Item TOOTHPASTE = RegistryTool.register(new Item(new Item.Properties().defaultDurability(40).setNoRepair().tab(ModCreativeModeTab.TAB_KEEP_YOUR_MOUTH_CLEAN)), "toothpaste");
    public static final Item POWERFUL_ABRASIVE_PASTE = RegistryTool.register(new Item(new Item.Properties().defaultDurability(20).setNoRepair().tab(ModCreativeModeTab.TAB_KEEP_YOUR_MOUTH_CLEAN)), "powerful_abrasive_paste");

    public static void clinit() {

    }
}

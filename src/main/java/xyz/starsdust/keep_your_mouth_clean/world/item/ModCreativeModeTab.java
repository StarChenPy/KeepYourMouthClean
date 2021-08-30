package xyz.starsdust.keep_your_mouth_clean.world.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/23
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class ModCreativeModeTab {
    public static final CreativeModeTab TAB_KEEP_YOUR_MOUTH_CLEAN = new CreativeModeTab("keep_your_mouth_clean") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.TOOTHBRUSH);
        }
    }.setRecipeFolderName("keep_your_mouth_clean_mod");
}

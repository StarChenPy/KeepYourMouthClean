package xyz.starsdust.keep_your_mouth_clean.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/26
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class ModMobEffect extends MobEffect {
    protected ModMobEffect(MobEffectCategory category, int color, @Nullable Item... items) {
        super(category, color);
    }

    @Override
    public List<ItemStack> getCurativeItems() {
        return new ArrayList<>();
    }
}

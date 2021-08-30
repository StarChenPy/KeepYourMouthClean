package xyz.starsdust.keep_your_mouth_clean.world.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import xyz.starsdust.keep_your_mouth_clean.toolbox.RegistryTool;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/26
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class ModMobEffects {
    public static final MobEffect TOOTH_DECAY = RegistryTool.register(new ModMobEffect
                    (MobEffectCategory.HARMFUL, 0x999999), "tooth_decay");

    public static final MobEffect DAMAGED_MOUTH = RegistryTool.register(new ModMobEffect
                    (MobEffectCategory.HARMFUL, 0xCC0000), "damaged_mouth");

    public static final MobEffect CLEAN_MOUTH = RegistryTool.register(new ModMobEffect
                    (MobEffectCategory.BENEFICIAL, 0xFFFF33), "clean_mouth");

    public static void clinit() {

    }
}

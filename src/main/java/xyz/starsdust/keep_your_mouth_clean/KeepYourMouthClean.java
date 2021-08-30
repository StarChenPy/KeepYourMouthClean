package xyz.starsdust.keep_your_mouth_clean;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import xyz.starsdust.keep_your_mouth_clean.event.GivePlayerToothDecay;
import xyz.starsdust.keep_your_mouth_clean.event.IncreasePlayerEatingTime;
import xyz.starsdust.keep_your_mouth_clean.event.PlayerDeductsBloodWhenEating;
import xyz.starsdust.keep_your_mouth_clean.event.PlayerEatToGainExtraSatiety;
import xyz.starsdust.keep_your_mouth_clean.toolbox.RegistryTool;
import xyz.starsdust.keep_your_mouth_clean.world.effect.ModMobEffects;
import xyz.starsdust.keep_your_mouth_clean.world.item.ModItems;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/23
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
@Mod(KeepYourMouthClean.MODID)
public class KeepYourMouthClean {
    public static final String MODID = "keep_your_mouth_clean";

    public KeepYourMouthClean() {
        ModItems.clinit();
        ModMobEffects.clinit();
        RegistryTool.init();

        GivePlayerToothDecay.init();
        IncreasePlayerEatingTime.init();
        PlayerDeductsBloodWhenEating.init();
        PlayerEatToGainExtraSatiety.init();

        MinecraftForge.EVENT_BUS.register(KeepYourMouthClean.class);
    }
}

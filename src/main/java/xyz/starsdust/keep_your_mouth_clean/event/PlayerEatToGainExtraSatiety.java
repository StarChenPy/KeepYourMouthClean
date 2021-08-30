package xyz.starsdust.keep_your_mouth_clean.event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import xyz.starsdust.keep_your_mouth_clean.world.effect.ModMobEffects;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/30
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class PlayerEatToGainExtraSatiety {
    @SubscribeEvent
    public void playerEatToGainExtraSatiety(LivingEntityUseItemEvent.Finish event) {
        if (event.getItem().isEdible()) {
            if (event.getEntity() instanceof Player player) {
                MobEffectInstance effect = player.getEffect(ModMobEffects.CLEAN_MOUTH);
                if (effect != null) {
                    int effectLevel = effect.getAmplifier() + 1;
                    player.getFoodData().eat(effectLevel, 0.5f);
                }
            }
        }
    }

    public static void init() {
        //这玩意只能放在Forge总线里
        MinecraftForge.EVENT_BUS.register(new PlayerEatToGainExtraSatiety());
    }
}

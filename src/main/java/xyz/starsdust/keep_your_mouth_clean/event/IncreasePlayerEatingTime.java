package xyz.starsdust.keep_your_mouth_clean.event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import xyz.starsdust.keep_your_mouth_clean.world.effect.ModMobEffects;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/29
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class IncreasePlayerEatingTime {
    @SubscribeEvent
    public void increasePlayerEatingTime(LivingEntityUseItemEvent.Start event) {
        if (event.getItem().isEdible()) {
            if (event.getEntity() instanceof LivingEntity entity) {
                //获取生物的蛀牙等级
                MobEffectInstance effect = entity.getEffect(ModMobEffects.TOOTH_DECAY);
                if (effect != null) {
                    int useDuration = event.getDuration();
                    int extraDuration = (effect.getAmplifier() + 1) * 16;
                    //增加吃饭的时间
                    event.setDuration(useDuration + extraDuration);
                }
            }
        }
    }

    public static void init() {
        //这玩意只能放在Forge总线里
        MinecraftForge.EVENT_BUS.register(new IncreasePlayerEatingTime());
    }
}

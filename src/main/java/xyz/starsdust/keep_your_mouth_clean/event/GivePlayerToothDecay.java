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
 * 创建时间：2021/8/26
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class GivePlayerToothDecay {
    @SubscribeEvent
    public void listeningToEat(LivingEntityUseItemEvent.Finish event) {
        if (event.getItem().isEdible()) {
            if (event.getEntity() instanceof LivingEntity entity) {
                if (Math.random() < 0.1) {
                    givePlayerEffect(entity);
                }
            }
        }
    }

    /**
     * 该方法用于给吃完东西的玩家上debuff
     * @param entity 生物实体
     */
    private void givePlayerEffect(LivingEntity entity) {
        //获取玩家身上的buff
        MobEffectInstance effect = entity.getEffect(ModMobEffects.TOOTH_DECAY);
        MobEffectInstance effect1 = entity.getEffect(ModMobEffects.DAMAGED_MOUTH);

        //如果有实体口腔健康buff就不上debuff
        if (entity.getEffect(ModMobEffects.CLEAN_MOUTH) == null) {
            if (effect != null) {
                //等级限制，防止超过4级
                if (effect.getAmplifier() < 3) {
                    //提升等级
                    effect.update(new MobEffectInstance(ModMobEffects.TOOTH_DECAY, 86400, effect.getAmplifier() + 1));
                } else if (effect1 != null) {
                    //等级限制，防止超过3级
                    if (effect.getAmplifier() < 2) {
                        //提升等级
                        effect.update(new MobEffectInstance(ModMobEffects.DAMAGED_MOUTH, 28800, effect1.getAmplifier() + 1));
                    }
                } else {
                    //没有buff就满上！
                    entity.addEffect(new MobEffectInstance(ModMobEffects.DAMAGED_MOUTH, 28800));
                }
            } else {
                //没有buff就满上！
                entity.addEffect(new MobEffectInstance(ModMobEffects.TOOTH_DECAY, 86400));
            }
        }
    }

    public static void init() {
        //这玩意只能放在Forge总线里
        MinecraftForge.EVENT_BUS.register(new GivePlayerToothDecay());
    }
}

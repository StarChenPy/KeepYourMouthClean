package xyz.starsdust.keep_your_mouth_clean.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
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
public class PlayerDeductsBloodWhenEating {
    @SubscribeEvent
    public void playerDeductsBloodWhenEating(LivingEntityUseItemEvent.Finish event) {
        if (event.getItem().isEdible()) {
            if (event.getEntity() instanceof LivingEntity entity) {
                //获取buff等级
                MobEffectInstance effect = entity.getEffect(ModMobEffects.DAMAGED_MOUTH);
                if (effect != null) {
                    //造成伤害
                    int damage = (effect.getAmplifier() + 1) * 2;
                    entity.hurt(DamageSource.CACTUS, damage);
                }
            }
        }
    }

    public static void init() {
        //这玩意只能放在Forge总线里
        MinecraftForge.EVENT_BUS.register(new PlayerDeductsBloodWhenEating());
    }
}

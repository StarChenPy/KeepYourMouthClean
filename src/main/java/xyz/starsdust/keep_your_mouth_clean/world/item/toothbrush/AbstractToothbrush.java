package xyz.starsdust.keep_your_mouth_clean.world.item.toothbrush;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import xyz.starsdust.keep_your_mouth_clean.world.effect.ModMobEffects;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/25
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class AbstractToothbrush extends Item {
    protected static final String NBT = "toothpaste";
    private final int timeUsed;

    public AbstractToothbrush(Item.Properties item) {
        this(item, 200);
    }

    public AbstractToothbrush(Item.Properties item, int timeUsedIn) {
        super(item.stacksTo(1));
        this.timeUsed = timeUsedIn;
    }

    /**
     * 决定了刷牙所需的时间
     * @param itemStack 物品
     * @return 时间
     */
    @Override
    @ParametersAreNonnullByDefault
    public int getUseDuration(ItemStack itemStack) {
        return timeUsed;
    }

    /**
     * 使用时的动画 这里用的吃东西的动画，我觉得还蛮合适的
     * @param itemStack 物品
     * @return 动画类型
     */
    @Nonnull
    @Override
    @ParametersAreNonnullByDefault
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.EAT;
    }


    /**
     * 清洁口腔
     * @param entity 实体
     * @param maximumCapacity 允许的最大蛀牙等级
     */
    protected void clean(LivingEntity entity, int maximumCapacity) {
        MobEffectInstance effect = entity.getEffect(ModMobEffects.TOOTH_DECAY);
        MobEffectInstance effect1 = entity.getEffect(ModMobEffects.CLEAN_MOUTH);

        //这边是除蛀
        if (effect != null) {
            if (effect.getAmplifier() == 0) {
                entity.removeEffect(effect.getEffect());
            } else {
                if (effect.getAmplifier() < maximumCapacity) {
                    entity.removeEffect(effect.getEffect());
                    entity.addEffect(new MobEffectInstance(effect.getEffect(), effect.getDuration(), effect.getAmplifier() - 1));
                }
            }
        } else if (effect1 != null) {
            //这边是加口腔清洁buff
            final int maxLevel = 3;
            if (effect1.getAmplifier() < maxLevel) {
                effect1.update(new MobEffectInstance(effect1.getEffect(), effect1.getDuration(), effect1.getAmplifier() + 1));
            } else {
                effect1.update(new MobEffectInstance(effect1.getEffect(), 9600, effect1.getAmplifier()));
            }
        } else {
            entity.addEffect(new MobEffectInstance(ModMobEffects.CLEAN_MOUTH, 9600));
        }
    }
}

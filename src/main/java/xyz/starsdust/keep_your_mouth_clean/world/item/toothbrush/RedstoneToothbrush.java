package xyz.starsdust.keep_your_mouth_clean.world.item.toothbrush;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import xyz.starsdust.keep_your_mouth_clean.world.item.ModCreativeModeTab;
import xyz.starsdust.keep_your_mouth_clean.world.item.ModItems;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/25
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class RedstoneToothbrush extends AbstractToothbrush {
    protected static final String NBT2 = "powerful";

    public RedstoneToothbrush() {
        super(new Item.Properties()
                .stacksTo(1)
                .tab(ModCreativeModeTab.TAB_KEEP_YOUR_MOUTH_CLEAN), 100);
    }

    @Nonnull
    @Override
    @ParametersAreNonnullByDefault
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!itemStack.hasTag()) {
            CompoundTag tag = new CompoundTag();
            tag.putBoolean(NBT, false);
            tag.putBoolean(NBT2, false);
            itemStack.setTag(tag);
        }

        assert itemStack.getTag() != null;
        if (!itemStack.getTag().contains(NBT)) {
            itemStack.getTag().putBoolean(NBT, false);
            itemStack.getTag().putBoolean(NBT2, false);
        }

        assert itemStack.getTag() != null;
        if (itemStack.getTag().getBoolean(NBT)) {
            player.startUsingItem(hand);
        } else {
            ItemStack offhandItem = player.getOffhandItem();
            if (offhandItem.getItem().equals(ModItems.TOOTHPASTE) || offhandItem.getItem().equals(ModItems.POWERFUL_ABRASIVE_PASTE)) {
                if (offhandItem.getDamageValue() <= offhandItem.getMaxDamage()) {
                    offhandItem.setDamageValue(offhandItem.getDamageValue() + 1);
                    itemStack.getTag().putBoolean(NBT, true);
                    if (offhandItem.getItem().equals(ModItems.POWERFUL_ABRASIVE_PASTE)) {
                        itemStack.getTag().putBoolean(NBT2, true);
                    }
                } else {
                    return InteractionResultHolder.fail(itemStack);
                }
            } else {
                return InteractionResultHolder.pass(itemStack);
            }
        }

        return InteractionResultHolder.success(itemStack);
    }

    @Nonnull
    @Override
    @ParametersAreNonnullByDefault
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity entity) {
        if (entity instanceof Player) {
            //完成刷牙
            ((Player)entity).getCooldowns().addCooldown(this, 200);

            assert itemStack.getTag() != null;
            if (itemStack.getTag().getBoolean(NBT)) {
                clean(entity, 4);

                if (itemStack.getTag().getBoolean(NBT2)) {
                    entity.hurt(DamageSource.MAGIC, 4.0f);
                }
            }

            itemStack.getTag().putBoolean(NBT, false);
            itemStack.getTag().putBoolean(NBT2, false);
        }
        return itemStack;
    }

    @Override
    @ParametersAreNonnullByDefault
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(new TranslatableComponent(I18n.get("tooltip.keep_your_mouth_clean.redstone_toothbrush")));
    }
}

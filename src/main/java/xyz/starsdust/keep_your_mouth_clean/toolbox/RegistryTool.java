package xyz.starsdust.keep_your_mouth_clean.toolbox;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import xyz.starsdust.keep_your_mouth_clean.KeepYourMouthClean;

import java.util.ArrayList;
import java.util.List;

/**
 * 此文件是 KeepYourMouthClean 的一部分
 * <p>
 * 创建时间：2021/8/23
 *
 * @author Starsdust
 * <p>
 * 版权没有，仿冒不究，如有雷同，纯属巧合
 **/
public class RegistryTool {
    private static List<Item> itemList = new ArrayList<>();
    private static List<MobEffect> mobEffectList = new ArrayList<>();

    public static Item register(Item item, String name) {
        itemList.add(item.setRegistryName(KeepYourMouthClean.MODID, name));
        return item;
    }

    public static MobEffect register(MobEffect mobEffect, String effectName) {
        mobEffectList.add(mobEffect.setRegistryName(KeepYourMouthClean.MODID, effectName));
        return mobEffect;
    }

    @SubscribeEvent
    public static void onRegisterItem(RegistryEvent.Register<Item> itemRegister) {
        final IForgeRegistry<Item> registry = itemRegister.getRegistry();
        for (Item item : itemList) {
            registry.register(item);
        }
        itemList = null;
    }

    @SubscribeEvent
    public static void onRegisterMobEffect(RegistryEvent.Register<MobEffect> mobEffectRegister) {
        final IForgeRegistry<MobEffect> registry = mobEffectRegister.getRegistry();
        for (MobEffect mobEffect : mobEffectList) {
            registry.register(mobEffect);
        }
        mobEffectList = null;
    }

    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().register(RegistryTool.class);
    }
}

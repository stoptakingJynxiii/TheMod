package net.suzi.themod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;



public class ModFoods {

    public static final FoodProperties BURGER = new FoodProperties.Builder()
            .alwaysEdible()
            .nutrition(0)
            .saturationModifier(0)
            .effect(new MobEffectInstance(MobEffects.POISON,1000),1.0F)
            .effect(new MobEffectInstance(MobEffects.HARM,10),1.0F)
            .effect(new MobEffectInstance(MobEffects.CONFUSION,1000),1.0F)
            .build();

}

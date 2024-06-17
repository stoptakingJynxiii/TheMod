package net.suzi.themod.item.custom;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlueRoseItem extends SwordItem {
    public BlueRoseItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 3)); // Apply freezing effect
            Level level = target.level();
            if (level instanceof ServerLevel) {
                ((ServerLevel)level).sendParticles(ParticleTypes.SNOWFLAKE, target.getX(), target.getY(1), target.getZ(), 30, 0.5, 0.5, 0.5, 0.1);
            }
            target.level().playSound(null, target.getX(), target.getY(), target.getZ(), SoundEvents.SNOW_BREAK, SoundSource.PLAYERS, 1.0F, 1.0F);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
package net.suzi.themod.item.custom;


import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.network.chat.contents.TranslatableFormatException;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class BurgerItem extends Item {

    public BurgerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();

        if (player != null) {
            playCowSound(world, player);
        }
        return InteractionResult.SUCCESS;
    }

    private void playCowSound(Level world, Player player) {
        SoundEvent cowHurtSound = SoundEvents.COW_HURT;
        world.playSound(player, player.blockPosition(), cowHurtSound, player.getSoundSource(), 5, 1);
    }





    public Component getDeathMessage(LivingEntity entity, Entity source) {
        if (source instanceof LivingEntity livingSource) {
            return Component.translatable("death.attack.custom_food.player", entity.getDisplayName(), livingSource.getDisplayName());
        } else {
            return Component.translatable("death.attack.custom_food", entity.getDisplayName());
        }
    }
}






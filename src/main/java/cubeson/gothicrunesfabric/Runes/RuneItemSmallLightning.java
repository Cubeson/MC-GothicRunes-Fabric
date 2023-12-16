package cubeson.gothicrunesfabric.Runes;

import cubeson.gothicrunesfabric.Projectiles.SmallLightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RuneItemSmallLightning extends RuneItem{
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!hand.equals(Hand.MAIN_HAND)) return super.use(world, user, hand);

        user.getItemCooldownManager().set(this, 10);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, SoundCategory.NEUTRAL, 0.2F, 1F);
        SmallLightningEntity smallLightningEntity = new SmallLightningEntity(world, user);
        smallLightningEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0f, 3f, 0f);
        smallLightningEntity.setNoGravity(true);
        world.spawnEntity(smallLightningEntity);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return TypedActionResult.success(itemStack, world.isClient());

    }
}

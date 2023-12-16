package cubeson.gothicrunesfabric.Runes;

import cubeson.gothicrunesfabric.CustomDamageTypes;
import cubeson.gothicrunesfabric.Projectiles.FireArrowEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RuneItemFireArrow extends RuneItem{


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!hand.equals(Hand.MAIN_HAND)) return super.use(world, user, hand);

        user.getItemCooldownManager().set(this, 10);
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 0.5F, 1F);
        FireArrowEntity fireArrowEntity = new FireArrowEntity(world, user);
        //fireArrowEntity.setItem(itemStack);
        fireArrowEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0f, 2f, 0.1f);
        world.spawnEntity(fireArrowEntity);
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return TypedActionResult.success(itemStack, world.isClient());

    }
}

package cubeson.gothicrunesfabric.Projectiles;

import cubeson.gothicrunesfabric.GothicRunesFabric;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class SmallLightningEntity extends ThrownItemEntity {
    public SmallLightningEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public SmallLightningEntity(World world, LivingEntity owner) {
        super(GothicRunesFabric.SmallLightningEntity, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return Items.LIGHT_BLUE_DYE;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        if(entity instanceof  LivingEntity livingEntity){
            livingEntity.damage(getDamageSources().magic(),5f);
        }
    }
    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) { // checks if the world is client
            this.getWorld().sendEntityStatus(this, (byte)3); // particle?
            this.kill(); // kills the projectile
        }

    }

}

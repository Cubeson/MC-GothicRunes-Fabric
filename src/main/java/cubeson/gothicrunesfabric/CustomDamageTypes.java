package cubeson.gothicrunesfabric;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class CustomDamageTypes {
    public static final RegistryKey<DamageType> TEST_DAMAGE_TYPE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier("gothicrunes","test_damage"));
    public static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }
}

package cubeson.gothicrunesfabric;

import cubeson.gothicrunesfabric.Projectiles.FireArrowEntity;
import cubeson.gothicrunesfabric.Runes.RuneItemFireArrow;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GothicRunesFabric implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("gothicrunesfabric");
	public static final String ModID = "gothicrunes";
	public static final Item RUNE_ITEM_FIRE_ARROW = new RuneItemFireArrow();
	private static final ItemGroup RUNES_ITEM_GROUP = FabricItemGroup.builder()
			.icon( () -> new ItemStack(RUNE_ITEM_FIRE_ARROW))
			.displayName(Text.translatable("itemGroup.gothicrunes.runes_item_group"))
			.entries((context,entries) -> {
				entries.add(RUNE_ITEM_FIRE_ARROW);
			})
			.build();

	public static final EntityType<FireArrowEntity> FireArrowEntityType = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(ModID,"fire_arrow"),
			FabricEntityTypeBuilder.<FireArrowEntity>create(SpawnGroup.MISC, FireArrowEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F,0.25F))
					.trackRangeBlocks(8).trackedUpdateRate(10)
					.build()
	);

	@Override
	public void onInitialize() {

		Registry.register(Registries.ITEM
				,new Identifier(ModID,"rune_fire_arrow")
				,RUNE_ITEM_FIRE_ARROW);

		Registry.register(Registries.ITEM_GROUP
				, new Identifier(ModID,"runes_item_group")
				,RUNES_ITEM_GROUP);



		//ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
		//				.register(content -> {content.add(RUNE_ITEM_FIRE_ARROW);});

		LOGGER.info("Hello Fabric world!");
	}
}
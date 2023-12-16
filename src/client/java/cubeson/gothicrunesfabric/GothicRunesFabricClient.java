package cubeson.gothicrunesfabric;

import cubeson.gothicrunesfabric.Projectiles.SmallLightningEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class GothicRunesFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		EntityRendererRegistry.register(GothicRunesFabric.FireArrowEntityType, FlyingItemEntityRenderer::new);
		EntityRendererRegistry.register(GothicRunesFabric.SmallLightningEntity, FlyingItemEntityRenderer::new);
	}
}
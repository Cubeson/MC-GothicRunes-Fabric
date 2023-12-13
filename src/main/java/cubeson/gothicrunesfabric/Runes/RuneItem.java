package cubeson.gothicrunesfabric.Runes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;

public abstract class RuneItem extends Item {

    public RuneItem() {
        super(new Settings().maxCount(1));
    }
}

package cubex2.cs4.plugins.vanilla;

import cubex2.cs4.plugins.vanilla.item.ItemArmor;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ContentItemArmorHelmet extends ContentItemArmor
{
    @Override
    protected ItemArmor createItem()
    {
        return new ItemArmor(this, EntityEquipmentSlot.HEAD);
    }
}

package github.postyizhan.monsterspawner.hook;

import io.th0rgal.oraxen.api.OraxenItems;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class OraxenHook implements ItemHook {
    @Override
    public String getName() {
        return "oraxen";
    }

    @Override
    public boolean isEnabled() {
        try {
            Class.forName("io.th0rgal.oraxen.api.OraxenItems");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @Override
    public ItemStack getItem(String id, Player player) {
        if (!isEnabled()) return null;
        return OraxenItems.getItemById(id).build();
    }

    @Override
    public String getItemId(ItemStack item) {
        if (!isEnabled()) return null;
        return OraxenItems.getIdByItem(item);
    }
} 
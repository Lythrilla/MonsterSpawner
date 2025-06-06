package github.postyizhan.monsterspawner.hook;

import dev.lone.itemsadder.api.CustomStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ItemsAdderHook implements ItemHook {
    @Override
    public String getName() {
        return "itemsadder";
    }

    @Override
    public boolean isEnabled() {
        try {
            Class.forName("dev.lone.itemsadder.api.CustomStack");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @Override
    public ItemStack getItem(String id, Player player) {
        if (!isEnabled()) return null;
        CustomStack customStack = CustomStack.getInstance(id);
        return customStack != null ? customStack.getItemStack() : null;
    }

    @Override
    public String getItemId(ItemStack item) {
        if (!isEnabled()) return null;
        CustomStack customStack = CustomStack.byItemStack(item);
        return customStack != null ? customStack.getId() : null;
    }
} 
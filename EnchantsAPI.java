package me.IlluminatiFish.enchantmentsapi.EnchantsAPI;

import java.util.List;
import me.IlluminatiFish.enchantmentsapi.EnchantsAPI.Utils.Util;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public class EnchantsAPI {
  public static boolean hasCustomEnchant(ItemStack item, String enchantment) {
    if (item != null && 
      item.hasItemMeta()) {
      if (item.getItemMeta().hasLore()) {
        List<String> lore = item.getItemMeta().getLore();
        for (int i = 0; i < lore.size(); i++) {
          String eal = lore.get(i);
          try {
            int f = eal.lastIndexOf(" ") + 1;
            String roman_level = eal.substring(f);
            int decimal_level = Util.romanToDecimal(roman_level);
            String enchant_on_lore = eal.substring(0, f - 1);
            String stripped = ChatColor.stripColor(enchant_on_lore);
            if (stripped.equals(ChatColor.stripColor(enchantment)))
              return true; 
          } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {}
        } 
      } 
      return false;
    } 
    return false;
  }
  
  public static int getEnchantLevel(ItemStack item, String enchantment) {
    if (item != null) {
      if (item.hasItemMeta() && 
        item.getItemMeta().hasLore()) {
        List<String> lore = item.getItemMeta().getLore();
        for (int i = 0; i < lore.size(); i++) {
          String eal = lore.get(i);
          try {
            int f = eal.lastIndexOf(" ") + 1;
            String enchant_on_lore = eal.substring(0, f - 1);
            String stripped = ChatColor.stripColor(enchant_on_lore);
            if (ChatColor.stripColor(enchant_on_lore).equals(ChatColor.stripColor(enchantment))) {
              String roman_level = eal.substring(f);
              int decimal_level = Util.romanToDecimal(roman_level);
              return decimal_level;
            } 
          } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {}
        } 
      } 
      return -2;
    } 
    return -3;
  }
}

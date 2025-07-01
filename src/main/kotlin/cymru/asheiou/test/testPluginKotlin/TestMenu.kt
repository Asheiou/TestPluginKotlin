package cymru.asheiou.test.testPluginKotlin

import fr.minuskube.inv.ClickableItem
import fr.minuskube.inv.SmartInventory
import fr.minuskube.inv.content.InventoryContents
import fr.minuskube.inv.content.InventoryProvider
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryType
import org.bukkit.inventory.ItemStack
import org.bukkit.plugin.java.JavaPlugin
import java.util.function.Consumer

open class TestMenu(open val plugin: JavaPlugin) : InventoryProvider {
  lateinit var TESTMENU: SmartInventory

  fun load() {
    TESTMENU = SmartInventory.builder()
      .id("testGui")
      .provider(this)
      .size(3, 3)
      .type(InventoryType.DROPPER)
      .title("TestMenu")
      .build()
  }

  fun getMenu(): SmartInventory {
    return TESTMENU
  }

  override fun init(p: Player, contents: InventoryContents) {
    contents.fill(ClickableItem.of(ItemStack(Material.STONE), Consumer { e ->
      e.isCancelled = true
      p.sendMessage("${ChatColor.RED}Click!")
    }));
  }

  override fun update(p: Player, contents: InventoryContents) {
    return;
  }
}
package cymru.asheiou.test.testPluginKotlin

import fr.minuskube.inv.SmartInvsPlugin
import org.bukkit.plugin.java.JavaPlugin

class TestPluginKotlin : JavaPlugin() {

  override fun onEnable() {
    getCommand("test")?.setExecutor(TestCommand(this))
    logger.info("Test plugin loaded!")
  }

  override fun onDisable() {
    // Plugin shutdown logic
  }
}

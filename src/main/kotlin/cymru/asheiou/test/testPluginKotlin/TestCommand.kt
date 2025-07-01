package cymru.asheiou.test.testPluginKotlin

import fr.minuskube.inv.SmartInventory
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class TestCommand(val plugin: JavaPlugin) : CommandExecutor {
  lateinit var MENU: SmartInventory

  override fun onCommand(
    sender: CommandSender,
    command: Command,
    label: String,
    args: Array<out String>
  ): Boolean {
    if (sender !is Player) {
      sender.sendMessage("This command can only be executed by player!")
      return true
    }
    if (!::MENU.isInitialized) {
      val testMenu = TestMenu(plugin)
      testMenu.load()
      MENU = testMenu.getMenu()
    }
    MENU.open(sender)
    return true
  }
}
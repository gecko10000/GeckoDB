package gecko10000.geckodb

import org.apache.logging.log4j.LogManager
import org.bukkit.plugin.java.JavaPlugin

class GeckoDB : JavaPlugin() {

    override fun onEnable() {
        (LogManager.getRootLogger() as org.apache.logging.log4j.core.Logger).addFilter(XodusFilter())
    }

}

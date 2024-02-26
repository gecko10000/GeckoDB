package gecko10000.geckodb

import jetbrains.exodus.entitystore.PersistentEntityStore
import jetbrains.exodus.entitystore.PersistentEntityStores
import jetbrains.exodus.env.EnvironmentConfig
import jetbrains.exodus.env.Environments
import jetbrains.exodus.log.LogConfig
import java.io.File

object EntityStoreManager {
    private val entityStores = mutableMapOf<File, PersistentEntityStore>()

    private fun createNew(file: File): PersistentEntityStore {
        val environmentConfig = EnvironmentConfig()
        val logConfig = LogConfig()
            .setLocation(file.path)
        val log = Environments.newLogInstance(logConfig, environmentConfig)
        val environment = Environments.newInstance(
            log, environmentConfig
        )
        return PersistentEntityStores.newInstance(environment)
    }

    fun getOrCreate(file: File): PersistentEntityStore {
        val existing = entityStores[file]
        if (existing == null) {
            val entityStore = createNew(file)
            entityStores[file] = entityStore
            return entityStore
        }
        return existing
    }
}

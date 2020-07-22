package nobdore.com.cache.test

import nobdore.com.cache.model.Config

/**
 * Created by AnkitSingh on 7/12/20.
 */
object ConfigDataFactory {

    fun makeCachedConfig(): Config {
        return Config(DataFactory.randomInt(), DataFactory.randomLong())
    }

}
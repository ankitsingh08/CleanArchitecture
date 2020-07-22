package nobdore.com.data.test

import java.util.*
import java.util.concurrent.ThreadLocalRandom

/**
 * Created by AnkitSingh on 7/11/20.
 */
object DataFactory {

    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

    fun randomLong(): Long {
        return randomInt().toLong()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }

}
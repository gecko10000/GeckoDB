package gecko10000.geckodb

import com.google.gson.ReflectionAccessFilter.FilterResult
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.Marker
import org.apache.logging.log4j.core.Filter
import org.apache.logging.log4j.core.LifeCycle
import org.apache.logging.log4j.core.LogEvent
import org.apache.logging.log4j.core.Logger
import org.apache.logging.log4j.message.Message

class XodusFilter : Filter {

    companion object {
        private const val STACKTRACE_PREFIX = "Interruptible file channel will be used"
    }

    private fun check(msg: String?): Filter.Result {
        msg ?: return Filter.Result.NEUTRAL
        if (msg.startsWith(STACKTRACE_PREFIX)) {
            return Filter.Result.DENY
        }
        return Filter.Result.NEUTRAL
    }

    override fun getState() = LifeCycle.State.STARTED

    override fun initialize() {
    }

    override fun start() {
    }

    override fun stop() {
    }

    override fun isStarted(): Boolean {
        return true
    }

    override fun isStopped(): Boolean {
        return false
    }

    override fun getOnMismatch(): Filter.Result {
        return Filter.Result.NEUTRAL
    }

    override fun getOnMatch(): Filter.Result {
        return Filter.Result.NEUTRAL
    }

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        msg: String?,
        vararg params: Any?,
    ): Filter.Result = check(msg)

    override fun filter(logger: Logger?, level: Level?, marker: Marker?, message: String?, p0: Any?): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
    ): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
        p2: Any?,
    ): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
    ): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
    ): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
    ): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
        p6: Any?,
    ): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
        p6: Any?,
        p7: Any?,
    ): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
        p6: Any?,
        p7: Any?,
        p8: Any?,
    ): Filter.Result = check(message)

    override fun filter(
        logger: Logger?,
        level: Level?,
        marker: Marker?,
        message: String?,
        p0: Any?,
        p1: Any?,
        p2: Any?,
        p3: Any?,
        p4: Any?,
        p5: Any?,
        p6: Any?,
        p7: Any?,
        p8: Any?,
        p9: Any?,
    ): Filter.Result = check(message)

    override fun filter(logger: Logger?, level: Level?, marker: Marker?, msg: Any?, t: Throwable?): Filter.Result = check(msg?.toString())

    override fun filter(logger: Logger?, level: Level?, marker: Marker?, msg: Message?, t: Throwable?): Filter.Result = check(msg?.formattedMessage)

    override fun filter(event: LogEvent?): Filter.Result = check(event?.message?.formattedMessage)
}

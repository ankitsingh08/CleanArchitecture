package nobdore.com.domain.executor

import io.reactivex.Scheduler

/**
 * Created by AnkitSingh on 7/11/20.
 */
interface PostExecutionThread{
    val scheduler: Scheduler
}
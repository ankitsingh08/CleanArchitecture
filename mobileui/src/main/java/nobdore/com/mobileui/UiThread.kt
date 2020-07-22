package nobdore.com.mobileui

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import nobdore.com.domain.executor.PostExecutionThread
import javax.inject.Inject

/**
 * Created by AnkitSingh on 7/12/20.
 */
class UiThread @Inject constructor(): PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}
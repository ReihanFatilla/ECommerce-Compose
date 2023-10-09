package com.trawlbens.reift.e_commerce

import android.app.Application
import com.trawlbens.reift.e_commerce.di.listModules
import com.trawlbens.reift.e_commerce.utils.NotificationWorker
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        NotificationWorker.scheduleNotificationWorker(this)
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listModules
            )
        }
    }
}
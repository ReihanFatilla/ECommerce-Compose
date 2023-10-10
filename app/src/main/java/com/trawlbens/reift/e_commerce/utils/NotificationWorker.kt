package com.trawlbens.reift.e_commerce.utils

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.trawlbens.reift.core.domain.model.Product
import com.trawlbens.reift.e_commerce.MainActivity
import com.trawlbens.reift.e_commerce.R
import java.util.concurrent.TimeUnit

class NotificationWorker(
    private val context: Context,
    workerParameters: WorkerParameters
): Worker(context, workerParameters) {
    override fun doWork(): Result {
        createReminderNotification(context)
        return Result.success()
    }

    companion object {
        var notificationProduct = Product.DUMMY.random()

        val CHANNEL_ID = "ROUTINE_PRODUCT_NOTIFICATION"
        val NOTIFICATION_ID = 1
        fun createReminderNotification(context: Context) {
            val intent = Intent(context, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent = PendingIntent.getActivity(
                context, 0, intent,
                PendingIntent.FLAG_IMMUTABLE
            )

            createNotificationChannel(context)

            val builder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_product)
                .setContentTitle("${notificationProduct.name} is on Sale for only $${notificationProduct.price}!")
                .setContentText(notificationProduct.description)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)

            with(NotificationManagerCompat.from(context)) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    notify(NOTIFICATION_ID, builder.build())
                    return
                }
            }
        }

        private fun createNotificationChannel(context: Context) {
            val name = "Daily Reminders"
            val descriptionText = "Send Notification of last opened Product every 15 minutes"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        fun scheduleNotificationWorker(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build()

            val periodicWorkRequest = PeriodicWorkRequest.Builder(
                NotificationWorker::class.java,
                15,
                TimeUnit.MINUTES
            )
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                "notification_work",
                ExistingPeriodicWorkPolicy.REPLACE,
                periodicWorkRequest
            )
        }
    }


}
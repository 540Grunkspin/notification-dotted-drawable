package org.grunkspin.notificationdotteddrawable

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationDottedDrawable = NotificationDottedDrawable(this, R.drawable.ic_launcher_foreground)

        imageView = findViewById(R.id.imageView)
        imageView.setImageDrawable(notificationDottedDrawable)
    }
}

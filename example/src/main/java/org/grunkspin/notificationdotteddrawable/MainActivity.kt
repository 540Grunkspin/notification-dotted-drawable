package org.grunkspin.notificationdotteddrawable

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationDottedDrawable = NotificationDottedDrawable(this, R.drawable.ic_attach_money_black_24dp)

        val imageView: ImageView = findViewById(R.id.imageView)
        imageView.setImageDrawable(notificationDottedDrawable)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)
        for (i in (0 until 4)) {
            bottomNavigation.menu.add("Item $i").run {
                val drawable = notificationDottedDrawable.mutate() as NotificationDottedDrawable
                if (i % 2 == 0) drawable.hasDot = true
                icon = drawable
            }
        }
    }
}

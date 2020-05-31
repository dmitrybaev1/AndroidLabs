package com.example.lab5

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IProfile
import com.mikepenz.materialdrawer.util.DrawerItemViewHelper

class MainActivity : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    companion object{
        lateinit var mediaPlayer: MediaPlayer
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        mediaPlayer = MediaPlayer.create(this,R.raw.sound)
        val headerResult = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.ic_launcher_background)
            .addProfiles(
                ProfileDrawerItem().withName("Dmitry Baev").withEmail("dmitrybaev1@gmail.com")
                    .withIcon(getResources().getDrawable(R.drawable.ic_launcher_foreground))
            )
            .withOnAccountHeaderListener(object : AccountHeader.OnAccountHeaderListener {
                override fun onProfileChanged(view: View?, profile: IProfile<*>, current: Boolean): Boolean {
                    return false
                }
            })
            .build()
        val result = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolbar)
            .withAccountHeader(headerResult)
            .addDrawerItems(
                PrimaryDrawerItem().withName("fragment1").withIdentifier(1),
                PrimaryDrawerItem().withName("fragment2").withIdentifier(2),
                PrimaryDrawerItem().withName("fragment3").withIdentifier(3),
                PrimaryDrawerItem().withName("fragment4").withIdentifier(4),
                PrimaryDrawerItem().withName("fragment5").withIdentifier(5),
                PrimaryDrawerItem().withName("fragment6").withIdentifier(6)
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                    when(drawerItem.identifier) {
                        1L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Fragment1()).commit()
                        2L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Fragment2()).commit()
                        3L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Fragment3()).commit()
                        4L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Fragment4()).commit()
                        5L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Fragment5()).commit()
                        6L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Fragment6()).commit()
                    }
                    return false
                }
            })
            .build()
        result.setSelection(1)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }
}

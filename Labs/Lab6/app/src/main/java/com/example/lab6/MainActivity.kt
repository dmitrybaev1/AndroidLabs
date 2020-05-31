package com.example.lab6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IProfile

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,MainFragment()).commit()
        val headerResult = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.background)
            .addProfiles(
                ProfileDrawerItem().withName("Dmitry Baev").withEmail("dmitrybaev1@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_launcher_foreground))
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
                PrimaryDrawerItem().withName("Главная страница").withIdentifier(1)
                    .withTextColorRes(R.color.colorPrimaryDark).withSelectedColorRes(R.color.colorPrimary),
                DividerDrawerItem(),
                PrimaryDrawerItem().withName("Плейлист 1").withIdentifier(2)
                    .withTextColorRes(R.color.colorPrimaryDark).withSelectedColorRes(R.color.colorPrimary),
                PrimaryDrawerItem().withName("Плейлист 2").withIdentifier(3)
                    .withTextColorRes(R.color.colorPrimaryDark).withSelectedColorRes(R.color.colorPrimary),
                PrimaryDrawerItem().withName("Плейлист 3").withIdentifier(4)
                    .withTextColorRes(R.color.colorPrimaryDark).withSelectedColorRes(R.color.colorPrimary),
                DividerDrawerItem(),
                PrimaryDrawerItem().withName("О приложении").withIdentifier(5)
                    .withTextColorRes(R.color.colorPrimaryDark).withSelectedColorRes(R.color.colorPrimary)
            )
            .withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                    when(drawerItem.identifier) {
                        1L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,MainFragment()).commit()
                        2L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Playlist1()).commit()
                        3L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Playlist2()).commit()
                        4L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,Playlist3()).commit()
                        5L -> supportFragmentManager.beginTransaction().replace(R.id.frameLayout,AboutFragment()).commit()
                    }
                    return false
                }
            })
            .build()

    }
}

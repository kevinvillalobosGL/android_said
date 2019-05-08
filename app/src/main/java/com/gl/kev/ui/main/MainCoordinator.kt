package com.gl.kev.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.gl.kev.R
import com.gl.kev.navigation.Navigator
import com.gl.kev.ui.home.HomeFragment
import com.gl.kev.ui.notifications.NotificationsFragment
import com.gl.kev.ui.profile.ProfileFragment
import com.gl.kev.ui.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainCoordinator(private val supportFragmentManager: FragmentManager) {

    private var homeFragment: HomeFragment? = null
    private var profileFragment: ProfileFragment? = null
    private var notificationsFragment: NotificationsFragment? = null
    private var settingsFragment: SettingsFragment? = null

    fun showFirstFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            val fragment = getHomeFragment()
            Navigator.goToFragment(
                supportFragmentManager,
                fragment,
                R.id.container,
                fragment.javaClass.simpleName,
                false
            )
        }
    }

    fun getHomeFragment(): HomeFragment {
        if (homeFragment == null) homeFragment = HomeFragment()
        return homeFragment!!
    }

    fun getProfileFragment(): ProfileFragment {
        if (profileFragment == null) profileFragment = ProfileFragment()
        return profileFragment!!
    }

    fun getNotificationsFragment(): NotificationsFragment {
        if (notificationsFragment == null) notificationsFragment = NotificationsFragment()
        return notificationsFragment!!
    }

    fun getSettingsFragment(): SettingsFragment {
        if (settingsFragment == null) settingsFragment = SettingsFragment()
        return settingsFragment!!
    }

    fun getNavigationListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            var fragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    fragment = getHomeFragment()
                }
                R.id.navigation_profile -> {
                    fragment = getProfileFragment()
                }

                R.id.navigation_notifications -> {
                    fragment = getNotificationsFragment()
                }
                R.id.navigation_settings -> {
                    fragment = getSettingsFragment()
                }
            }

            if (fragment != null) {
                Navigator.goToFragment(
                    supportFragmentManager,
                    fragment,
                    R.id.container,
                    fragment.javaClass.simpleName,
                    false
                )
                true
            } else {
                false
            }
        }
    }

}
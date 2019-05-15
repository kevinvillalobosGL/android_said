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

    private val homeFragment: HomeFragment by lazy {
        HomeFragment()
    }
    private val profileFragment: ProfileFragment by lazy {
        ProfileFragment()
    }
    private val notificationsFragment: NotificationsFragment by lazy {
        NotificationsFragment()
    }
    private val settingsFragment: SettingsFragment by lazy {
        SettingsFragment()
    }

    fun showFirstFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            val fragment = homeFragment
            Navigator.goToFragment(
                supportFragmentManager,
                fragment,
                R.id.container,
                fragment.javaClass.simpleName,
                false
            )
        }
    }

    fun getNavigationListener(): BottomNavigationView.OnNavigationItemSelectedListener {
        return BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            var fragment: Fragment? = null
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    fragment = homeFragment
                }
                R.id.navigation_profile -> {
                    fragment = profileFragment
                }

                R.id.navigation_notifications -> {
                    fragment = notificationsFragment
                }
                R.id.navigation_settings -> {
                    fragment = settingsFragment
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
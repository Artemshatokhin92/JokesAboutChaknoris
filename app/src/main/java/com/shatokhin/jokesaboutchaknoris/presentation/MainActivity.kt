package com.shatokhin.jokesaboutchaknoris.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.shatokhin.jokesaboutchaknoris.R
import com.shatokhin.jokesaboutchaknoris.WebFragment
import dagger.hilt.android.AndroidEntryPoint

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by viewModels{ MainViewModelFactory() }
    private val bottomNavigation by lazy<BottomNavigationView> { findViewById(R.id.bottomNavigation) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initListenersBottomNavigation()

        if(supportFragmentManager.fragments.size == 0) switchFragment(JokesFragment(), JokesFragment.TAG)

        mainViewModel.errorLoading.observe(this, { textError ->
            Toast.makeText(this, textError, Toast.LENGTH_LONG).show()
        })
    }

    private fun switchFragment(nextFragment: Fragment, tagNextFragment: String){

        if(supportFragmentManager.fragments.size == 0) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, nextFragment, tagNextFragment)
                .commit()
        }

        else{
            val currentFragment: Fragment = supportFragmentManager.fragments.first { it.isVisible }
            val nextFragm: Fragment? = supportFragmentManager.findFragmentByTag(tagNextFragment)

            if (nextFragm != null) {
                supportFragmentManager
                    .beginTransaction()
                    .hide(currentFragment)
                    .show(nextFragm)
                    .commit()
            }
            else {
                supportFragmentManager
                    .beginTransaction()
                    .hide(currentFragment)
                    .add(R.id.fragmentContainer, nextFragment, tagNextFragment)
                    .commit()
            }
        }
    }

    private fun initListenersBottomNavigation() {
        bottomNavigation.setOnItemReselectedListener { false }
        bottomNavigation.setOnItemSelectedListener {
            if (it.itemId == R.id.nav_jokes) showJokesFragment()
            if (it.itemId == R.id.nav_web) showWebFragment()
            true
        }
    }

    private fun showJokesFragment() {
        switchFragment(JokesFragment(), JokesFragment.TAG)
    }

    private fun showWebFragment() {
        switchFragment(WebFragment(), WebFragment.TAG)
    }

    override fun onBackPressed() {
        val currentFragment: Fragment = supportFragmentManager.fragments.first { it.isVisible }
        if (currentFragment.tag == WebFragment.TAG) {
            val webFragment = currentFragment as WebFragment
            if (webFragment.webViewCanGoBack()) webFragment.webViewGoBack()
            else super.onBackPressed()
        }  else super.onBackPressed()
    }
}
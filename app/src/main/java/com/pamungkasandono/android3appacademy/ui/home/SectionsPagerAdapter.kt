package com.pamungkasandono.android3appacademy.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pamungkasandono.android3appacademy.R
import com.pamungkasandono.android3appacademy.ui.academy.AcademyFragment
import com.pamungkasandono.android3appacademy.ui.bookmark.BookmarkFragment

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private val TAB_TITLES = intArrayOf(R.string.home, R.string.bookmark)
    }

    override fun getItem(position: Int): Fragment {
        android.util.Log.d("asdasd TAB_TITLES", TAB_TITLES.size.toString())
        return when (position) {
            0 -> AcademyFragment()
            1 -> BookmarkFragment()
            else -> Fragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? = mContext.resources.getString(
        TAB_TITLES[position]
    )

    override fun getCount(): Int = TAB_TITLES.size
}
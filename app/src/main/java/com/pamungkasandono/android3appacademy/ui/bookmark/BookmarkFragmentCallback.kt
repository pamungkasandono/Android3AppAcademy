package com.pamungkasandono.android3appacademy.ui.bookmark

import com.pamungkasandono.android3appacademy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}

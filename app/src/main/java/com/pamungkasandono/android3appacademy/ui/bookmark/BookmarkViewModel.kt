package com.pamungkasandono.android3appacademy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.pamungkasandono.android3appacademy.data.CourseEntity
import com.pamungkasandono.android3appacademy.utils.DataDummy

class BookmarkViewModel: ViewModel() {
    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourse()
}
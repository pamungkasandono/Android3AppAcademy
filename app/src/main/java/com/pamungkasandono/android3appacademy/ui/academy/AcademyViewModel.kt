package com.pamungkasandono.android3appacademy.ui.academy

import androidx.lifecycle.ViewModel
import com.pamungkasandono.android3appacademy.data.CourseEntity
import com.pamungkasandono.android3appacademy.utils.DataDummy

class AcademyViewModel : ViewModel() {

    fun getCourse(): List<CourseEntity> = DataDummy.generateDummyCourse()
}
package com.pamungkasandono.android3appacademy.ui.detail

import androidx.lifecycle.ViewModel
import com.pamungkasandono.android3appacademy.data.CourseEntity
import com.pamungkasandono.android3appacademy.data.ModuleEntity
import com.pamungkasandono.android3appacademy.utils.DataDummy

class DetailCourseViewModel : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity {
        lateinit var course: CourseEntity
        val coursesEntities = DataDummy.generateDummyCourse()
        for (courseEntity in coursesEntities) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }
        return course
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)
}
package com.pamungkasandono.android3appacademy.ui.detail

import com.pamungkasandono.android3appacademy.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailCourseViewModelTest {
    private lateinit var viewModel: DetailCourseViewModel
    private val dummyCourse = DataDummy.generateDummyCourse()[0]
    private val courseId = dummyCourse.courseId

    @Before
    fun setup() {
        viewModel = DetailCourseViewModel()
        viewModel.setSelectedCourse(courseId)
    }

    @Test
    fun getCourse() {
        viewModel.setSelectedCourse(dummyCourse.courseId)
        val courseEntity = viewModel.getCourse()
        assertNotNull(courseEntity)
        assertEquals(dummyCourse.courseId, courseEntity.courseId)
        assertEquals(dummyCourse.title, courseEntity.title)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.deadline, courseEntity.deadline)
        assertEquals(dummyCourse.bookmarked, courseEntity.bookmarked)
    }

    @Test
    fun getModules() {
        val moduleEntities = viewModel.getModules()
        assertNotNull(moduleEntities)
        assertEquals(7, moduleEntities.size)
    }
}
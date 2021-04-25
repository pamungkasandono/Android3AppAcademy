package com.pamungkasandono.android3appacademy.ui.bookmark

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class BookmarkViewModelTest {
    private lateinit var vModel: BookmarkViewModel

    @Before
    fun setup() {
        vModel = BookmarkViewModel()
    }

    @Test
    fun getBookmarks() {
        val bookmarks = vModel.getBookmarks()
        assertNotNull(bookmarks)
        assertEquals(5, bookmarks.size)
    }
}
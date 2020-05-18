package com.interview.codetest.domain.model

import com.interview.codetest.data.response.LinksResponse
import com.interview.codetest.data.response.PageResponse
import com.interview.codetest.data.response.SectionResponse
import org.junit.Before
import org.junit.Test

class PageTest {

    lateinit var pageResponse: PageResponse

    @Before
    fun before() {
        pageResponse = PageResponse(
            null, "title", "description",
            LinksResponse(mutableListOf<SectionResponse>().apply {
                add(SectionResponse("1", "title", "link"))
                add(SectionResponse("2", "title", "link"))
                add(SectionResponse("3", "title", "link"))
            })
        )
    }

    @Test
    fun `check if root page`() {
        val root = Page(pageResponse)
        assert(root.isRoot())
    }


    @Test
    fun `check list items`() {
        val root = Page(pageResponse)
        assert(root.sections.size == 3)
    }

}
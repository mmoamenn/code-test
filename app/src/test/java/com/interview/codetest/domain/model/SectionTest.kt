package com.interview.codetest.domain.model

import com.interview.codetest.data.response.SectionResponse
import org.junit.Before
import org.junit.Test

class SectionTest {

    lateinit var sectionResponse: SectionResponse

    @Before
    fun before() {
        sectionResponse = SectionResponse("1", "title", "link")
    }

    @Test
    fun `check if remove {?dtg} from link`(){
        val section = Section(sectionResponse)
        assert(!section.href.contains("{?dtg}"))
    }

}
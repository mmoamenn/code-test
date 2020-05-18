package com.interview.codetest.domain.model

import com.interview.codetest.data.response.PageResponse

class Page(pageResponse: PageResponse) {

    val sectionID by lazy { pageResponse.sectionID }

    val title by lazy { pageResponse.title }

    val description by lazy { pageResponse.description }

    val sections: MutableList<Section> = ArrayList()

    init {
        pageResponse.links.sectionResponse.forEach {
            sections.add(Section(it))
        }
    }

    fun isRoot() =  sectionID == null

}
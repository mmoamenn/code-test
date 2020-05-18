package com.interview.codetest.domain.model

import com.interview.codetest.data.response.SectionResponse

class Section(sectionResponse: SectionResponse) {

    val id: String by lazy { sectionResponse.id }

    val title: String by lazy { sectionResponse.title }

    val href: String by lazy { sectionResponse.href.replace("{?dtg}", "") }

}
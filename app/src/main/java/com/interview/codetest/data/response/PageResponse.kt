package com.interview.codetest.data.response

import com.google.gson.annotations.SerializedName

data class PageResponse(
    @SerializedName("sectionId") val sectionID : String?,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("_links") val links: LinksResponse
)

data class LinksResponse(@SerializedName("viaplay:sections") val sectionResponse: List<SectionResponse>)

data class SectionResponse(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("href") val href: String
)
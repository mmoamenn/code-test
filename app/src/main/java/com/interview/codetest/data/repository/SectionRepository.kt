package com.interview.codetest.data.repository

import com.interview.codetest.core.bases.BaseRepository
import com.interview.codetest.domain.model.Page

class SectionRepository : BaseRepository() {

    private val root: String = "root"

    fun getCachedSections(): Page? {
        val root = cache.loadItem(root)
        return if (root != null) {
            Page(root)
        } else
            null
    }

    suspend fun getSections(): Page {
        val rootItem = network.call.getAllSections()
        cache.saveItem(root, rootItem)
        return Page(rootItem)
    }

    fun getCachedSection(sectionURL: String): Page? {
        val section = cache.loadItem(sectionURL)
        return if (section != null)
            Page(section)
        else
            null
    }

    suspend fun getSection(sectionURL: String): Page {
        val section = network.call.getSection(sectionURL)
        cache.saveItem(sectionURL, section)
        return Page(section)
    }

}
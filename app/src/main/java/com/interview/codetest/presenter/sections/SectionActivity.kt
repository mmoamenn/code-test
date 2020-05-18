package com.interview.codetest.presenter.sections

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.interview.codetest.R
import com.interview.codetest.data.response.DataStatus
import com.interview.codetest.domain.model.Section
import com.interview.codetest.presenter.sections.adapter.SectionAdapter
import kotlinx.android.synthetic.main.activity_section.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SectionActivity : AppCompatActivity(), SectionAdapter.OnItemSelected {

    private val view: SectionViewModel by viewModel()

    private val sectionAdapter: SectionAdapter by lazy { SectionAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_section)
        initRecyclers()
        initObservers()
    }

    private fun initRecyclers() {
        with(sectionsRecycler) {
            this.layoutManager = LinearLayoutManager(this@SectionActivity)
            this.setHasFixedSize(true)
            this.adapter = sectionAdapter
        }
    }

    private fun initObservers() {
        view.getSections()
        view.sectionLiveData.observe(this, Observer {
            when (it.dataStatus) {
                DataStatus.LOADING -> {
                    progress.visibility = View.VISIBLE
                }
                DataStatus.SUCCESS -> {
                    it.data?.run {
                        progress.visibility = View.GONE
                        titleTxt.text = this.title

                        if (!isRoot()) {
                            descriptionTxt.visibility = View.VISIBLE
                            descriptionTxt.text = this.description
                        } else {
                            descriptionTxt.visibility = View.GONE
                        }

                        sectionAdapter.addItems(sections)
                    }
                }
                DataStatus.ERROR -> {
                    progress.visibility = View.GONE
                    Toast.makeText(this, it.error!!.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun itemClicked(sectionResponse: Section) {
        view.getSection(sectionResponse.href)
    }

}
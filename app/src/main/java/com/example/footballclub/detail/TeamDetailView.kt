package com.example.footballclub.detail

import com.example.footballclub.models.Team

interface TeamDetailView {
    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data: List<Team>)
}
package com.example.footballclub.teams

import com.example.footballclub.models.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}
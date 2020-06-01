package com.example.footballclub.teams

import com.example.footballclub.models.TeamResponse
import com.example.footballclub.api.ApiRepository
import com.example.footballclub.api.TheSportDBApi
import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPresenter(private val view: TeamsFragment,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson){

    fun getTeamList(league: String?){
        view.showLoading()
        doAsync {
            val  data = gson.fromJson(apiRepository.doRequest(TheSportDBApi.getTeams(league)), TeamResponse::class.java)

            uiThread {
                view.hideLoading()
                view.showTeamList(data.teams)
            }
        }
    }
}

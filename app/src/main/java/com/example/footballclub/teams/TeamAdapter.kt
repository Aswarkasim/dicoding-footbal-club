package com.example.footballclub.teams

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.footballclub.R
import com.example.footballclub.models.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class TeamAdapter (private val teams: List<Team>, private val listener:(Team)->Unit)
    :RecyclerView.Adapter<TeamViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            TeamUI()
                .createView(AnkoContext.create(parent.context, parent))
        )
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position], listener)
    }

}

class TeamViewHolder(View: View): RecyclerView.ViewHolder(View){
    private val teamBadge: ImageView = View.findViewById(R.id.team_badge)
    private val teamName: TextView = View.findViewById(R.id.team_name)
    fun bindItem(teams: Team, listener: (Team) -> Unit){
        Picasso.get().load(teams.teamBadge).fit().into(teamBadge)
        teamName.text = teams.teamName

        itemView.setOnClickListener {
            listener(teams)
        }
    }
}


class TeamUI : AnkoComponent<ViewGroup>{
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout {
                lparams(matchParent, wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView{
                    id = R.id.team_badge
                }.lparams{
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = R.id.team_name
                    textSize = 16f
                }.lparams{
                    margin = dip(15)
                }
            }
        }
    }

}
package se.magictechnology.pia11recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    var people = mutableListOf<String>("Arne", "Bartil", "Caesar")

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val personName : TextView
        val personNumber : TextView

        init {
            personName = view.findViewById(R.id.personNameTV)
            personNumber = view.findViewById(R.id.personNumberTV)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        Log.i("pia11debug", "SKAPA RAD")

        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("pia11debug", "RITA RAD " + position.toString())

        holder.personName.text = people[position]
        holder.personNumber.text = position.toString()

        holder.itemView.setOnClickListener {
            people.removeAt(position)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int {
        return people.size
    }

}
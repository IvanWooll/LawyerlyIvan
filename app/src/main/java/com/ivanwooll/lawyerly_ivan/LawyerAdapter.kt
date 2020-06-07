package com.ivanwooll.lawyerly_ivan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import kotlinx.android.synthetic.main.list_item_lawyer.view.*

class LawyerAdapter(private val items: List<Lawyer>, private val callbacks: Callbacks) :
    RecyclerView.Adapter<VH>() {

    interface Callbacks {
        fun onClickLawyer(lawyer: Lawyer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_lawyer, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        val lawyer = items[holder.adapterPosition]
        val (firstName, lastName, speciality, rating, _, _, verified, cost, profileUrl, _) = lawyer
        holder.itemView.apply {
            imageViewVerified.visibility = if (verified) View.VISIBLE else View.INVISIBLE
            textViewLawyerName.text = "$firstName $lastName"
            textViewRating.text = rating
            textViewSpeciality.text = speciality
            textViewCost.text = cost
            imageViewProfile.load(profileUrl)

            setOnClickListener {
                callbacks.onClickLawyer(lawyer)
            }
        }
    }
}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView)
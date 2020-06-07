package com.ivanwooll.lawyerly_ivan

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import coil.api.load
import kotlinx.android.synthetic.main.layout_lawyer_detail.*
import kotlinx.android.synthetic.main.layout_ratings.*

class ActivityLawyerDetail : AppCompatActivity() {

    companion object {
        const val LAWYER = "lawyer"

        fun getStartIntent(context: Context, lawyer: Lawyer): Intent =
            Intent(context, ActivityLawyerDetail::class.java).apply {
                putExtra(LAWYER, lawyer)
            }
    }

    private val lawyer by lazy { intent.getParcelableExtra<Lawyer>(LAWYER) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_lawyer_detail)

        val textShader: Shader = LinearGradient(
            0F, 20F, 0F, 0F,
            intArrayOf(Color.parseColor("#FF1CEA91"), Color.parseColor("#FFE0FF5C")),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        textViewPromotion.paint.shader = textShader

        lawyer?.let {
            imageViewProfile.load(it.profileUrl)
            imageViewVerified.visibility = if (it.verified) View.VISIBLE else View.INVISIBLE
            textViewPromotion.visibility = if (it.promotionEnabled) View.VISIBLE else View.INVISIBLE
            textViewLawyerName.text = "${it.firstName}\n${it.lastName}"
            textViewSpeciality.text = it.speciality
            textViewCost.text = it.cost
            textViewRating.text = it.rating
            textViewReviews.text = it.reviewCount.toString()
            textViewRanking.text = it.ranking
        }

        imageViewBack.setOnClickListener { onBackPressed() }
    }


}
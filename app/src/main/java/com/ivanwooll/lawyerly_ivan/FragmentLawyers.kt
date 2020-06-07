package com.ivanwooll.lawyerly_ivan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.layout_lawyers.*

class FragmentLawyers : Fragment(), LawyerAdapter.Callbacks {

    private val lawyers = listOf(
        Lawyer(
            firstName = "Sam",
            lastName = "Smith",
            speciality = "Taxation",
            cost = "£60.00/h",
            rating = "3.5",
            reviewCount = 2,
            ranking = "1/18",
            profileUrl = "https://lh3.googleusercontent.com/proxy/FVtN3js5Bqx2qm9TSprbQ3-WGocVgxTXdN9K3DLunQ1yY102A0eFb9oj7GwgN18a2_6nAR5vbE7vyV3xGz9pBtICku9idiAKj9NxoDTGbAF9iB34-5DNdCOBA_49oiAOAkEJ_Yrr",
            verified = true,
            promotionEnabled = true
        ),
        Lawyer(
            firstName = "Dan",
            lastName = "Wallace",
            speciality = "Criminal",
            cost = "£40.00/h",
            rating = "4.5",
            reviewCount = 12,
            ranking = "2/18",
            profileUrl = "https://justatic.com/profile-images/1497865-1462971584-s.jpg"
        ),
        Lawyer(
            firstName = "Shelly",
            lastName = "Cromwell",
            speciality = "Conveyancing",
            cost = "£45.00/h",
            rating = "4.6",
            reviewCount = 6,
            ranking = "3/18",
            profileUrl = "https://www.criminal-lawyers.com.au/wp-content/uploads/2019/08/Kristina-Kothrakis-profile.jpg",
            verified = true
        ),
        Lawyer(
            firstName = "Shirley",
            lastName = "Chesterfield",
            speciality = "Taxation",
            cost = "£60.00/h",
            rating = "3.5",
            reviewCount = 8,
            ranking = "4/18",
            profileUrl = "https://static.wixstatic.com/media/54dee2_6b0fb6ec5328414f89d2e4bb7dbc583a~mv2.jpg/v1/fill/w_508,h_761,al_c,q_85,usm_0.66_1.00_0.01/Carolyn-West-Lawyer-Profile.webp",
            promotionEnabled = true
        ),
        Lawyer(
            firstName = "Shirley",
            lastName = "Smith",
            speciality = "International",
            cost = "£70.00/h",
            rating = "4.9",
            reviewCount = 0,
            ranking = "5/18",
            profileUrl = "https://justatic.com/profile-images/1639455-1583884394-s.jpg",
            verified = true
        ),
        Lawyer(
            firstName = "Sam",
            lastName = "Shirley",
            speciality = "Extradition",
            cost = "£90.00/h",
            rating = "4.4",
            reviewCount = 2,
            ranking = "5/18",
            profileUrl = "https://www.bizlawyerchina.com/wp-content/uploads/2018/09/sliderimg.png"
        )

    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.layout_lawyers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = LawyerAdapter(lawyers, this)
    }

    override fun onClickLawyer(lawyer: Lawyer) {
        startActivity(ActivityLawyerDetail.getStartIntent(requireContext(), lawyer))
    }
}
package com.ivanwooll.lawyerly_ivan

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Lawyer(
    val firstName: String,
    val lastName: String,
    val speciality: String,
    val rating: String,
    val reviewCount: Int,
    val ranking: String,
    val verified: Boolean = false,
    val cost: String,
    val profileUrl: String,
    val promotionEnabled: Boolean = false
) : Parcelable
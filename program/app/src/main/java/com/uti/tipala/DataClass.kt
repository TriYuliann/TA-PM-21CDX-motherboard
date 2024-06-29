package com.uti.tipala

import android.os.Parcel
import android.os.Parcelable

data class DataClass(
    val dataImage: Int,
    val dataTitle: String,
    val dataDesc: String,
    val dataDetailImage: Int,
    val latitude: Double,  // Tambahkan latitude
    val longitude: Double // Tambahkan longitude
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readDouble(),  // Baca latitude
        parcel.readDouble()   // Baca longitude
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataDesc)
        parcel.writeInt(dataDetailImage)
        parcel.writeDouble(latitude)  // Tulis latitude
        parcel.writeDouble(longitude) // Tulis longitude
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataClass> {
        override fun createFromParcel(parcel: Parcel): DataClass {
            return DataClass(parcel)
        }

        override fun newArray(size: Int): Array<DataClass?> {
            return arrayOfNulls(size)
        }
    }
}

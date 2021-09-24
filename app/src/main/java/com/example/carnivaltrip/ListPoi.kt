package com.example.carnivaltrip

import android.os.Parcel
import android.os.Parcelable

@parcelable
data class ListPoi(
    val titleItem:String,
    val obsItem:String,
    val quality:String,
    val image:String,
    val carnival:String,
    val obsCarnival:String,
    val temp:String,
    val date:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titleItem)
        parcel.writeString(obsItem)
        parcel.writeString(quality)
        parcel.writeString(image)
        parcel.writeString(carnival)
        parcel.writeString(obsCarnival)
        parcel.writeString(temp)
        parcel.writeString(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ListPoi> {
        override fun createFromParcel(parcel: Parcel): ListPoi {
            return ListPoi(parcel)
        }

        override fun newArray(size: Int): Array<ListPoi?> {
            return arrayOfNulls(size)
        }
    }

}

annotation class parcelable


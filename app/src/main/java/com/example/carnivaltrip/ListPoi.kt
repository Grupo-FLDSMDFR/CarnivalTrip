package com.example.carnivaltrip

import android.os.Parcel
import android.os.Parcelable

@parcelable
data class ListPoi(
    val titleItem: String?,
    val obsItem:String?,
    val quality:String?,
    val image:String?,
    val carnival:String?,
    val obsCarnival:String?,
    val temp:String?,
    val date:String?,
    val latitude:String?,
    val longitude:String?,
    val sites:Array<PopularSites>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("sites")
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
        parcel.writeString(latitude)
        parcel.writeString(longitude)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ListPoi

        if (!sites.contentEquals(other.sites)) return false

        return true
    }

    override fun hashCode(): Int {
        return sites.contentHashCode()
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


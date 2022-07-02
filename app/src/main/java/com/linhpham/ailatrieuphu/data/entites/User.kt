package com.linhpham.ailatrieuphu.data.entites

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.linhpham.ailatrieuphu.data.DataInfor

@Entity(tableName = DataInfor.Tables.USER)
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DataInfor.User.COLUMN_ID)
    @SerializedName("id")
    val id: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DataInfor.User.COLUMN_EMAIL)
    @SerializedName("id")
    val email: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DataInfor.User.COLUMN_ID)
    @SerializedName("full_name")
    val fullName: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = DataInfor.User.COLUMN_ID)
    @SerializedName("address")
    val address: String,

    )

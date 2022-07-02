package com.linhpham.ailatrieuphu.data

object DataInfor {
    const val DB_VERSION = "1.0"
    const val DB_NAME = "millionaire"

    sealed class Tables {
        companion object {
            const val USER = "user"
        }
    }

    sealed class User {
        companion object {
            const val COLUMN_ID = "id"
            const val COLUMN_EMAIL = "id"
            const val COLUMN_FULL_NAME = "id"
            const val COLUMN_ADDREESS = "id"
            const val COLUMN_AVATA = "id"
        }

    }
}
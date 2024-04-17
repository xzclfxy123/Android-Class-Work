package com.example.rally.data

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class Account(
    val name: String,
    val number: Int,
    val balance: Float,
    val color: Color
)

@Immutable
data class Bill(
    val name: String,
    val due: String,
    val amount: Float,
    val color: Color
)

object UserData{
    val accounts: List<Account> = listOf(
        Account(
            "Checking",
            123,
            246.8f,
            Color(0xFF39c5bb)
        ),
        Account(
            "Life Savings",
            456,
            357.9f,
            Color(0xFF39c5bb)
        ),
        Account(
            "Car Savings",
            789,
            135.79f,
            Color(0xFF39c5bb)
        )
    )
    val bill: List<Bill> = listOf(
        Bill(
            "lfxy01",
            "Apr 1",
            1234.5f,
            Color(0xFF39c5bb)
        )
    )

    fun getAccount(accountName: String?): Account {
        return accounts.first{it.name == accountName}
    }
}
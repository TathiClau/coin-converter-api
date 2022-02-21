package com.api.CoinConverter.helper

import com.api.CoinConverter.domain.ResponseCoinConversion
import com.api.CoinConverter.entity.Transaction
import com.api.CoinConverter.entity.Transaction.Companion.toTransaction
import java.util.*

fun buildTransaction(
    transactionId: UUID = UUID.randomUUID(),
    userId: UUID = UUID.randomUUID(),
    initialCoin: String = "EUR",
    initialValue: Double = 1.02,
    finalCoin: String = "BRL",
    finalValue: Double = 1.35,
    conversionRate: Double = 1.00
) = toTransaction (
    ResponseCoinConversion (
                transactionId,
                userId,
                initialCoin,
                initialValue,
                finalCoin,
                finalValue,
                conversionRate
            )

)

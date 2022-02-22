package com.api.CoinConverter.helper

import com.api.CoinConverter.domain.AddCoinConversion
import com.api.CoinConverter.domain.ResponseCoinConversion
import com.api.CoinConverter.entity.Transaction
import com.api.CoinConverter.entity.Transaction.Companion.toTransaction
import org.apache.tomcat.jni.Time
import java.sql.Timestamp
import java.text.DateFormat
import java.time.Instant
import java.time.LocalDateTime
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

fun buildAddCoinConversion(
    accessKey: String = UUID.randomUUID().toString(),
    userId: UUID = UUID.randomUUID(),
    initialCoin: String = "EUR",
    initialValue: Double = 1.02,
    finalCoin: String = "BRL"
) = AddCoinConversion (
        accessKey = accessKey,
        userId = userId,
        initialCoin = initialCoin,
        initialValue = initialValue,
        finalCoin = finalCoin
)

fun buildResponseConversionRate(
    success: Boolean = true,
    timestamp: Timestamp = Timestamp(1645490462),
    base: String = "EUR",
    date: Date = Date.from(Instant.now()),
    rates: Map<String, Double> = mapOf("AED", 4.156529)
) = ResponseConversionRate (
    success = success,
    timestamp = timestamp,
    base = base,
    date = date,
    finalCoin = finalCoin
)



data class ResponseConversionRate (val success: Boolean,
                                   val timestamp: Timestamp,
                                   val base: String,
                                   val date: Date,
                                   val rates: Map<String, Double>)

package com.api.CoinConverter.domain

import java.sql.Timestamp
import java.util.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class AddCoinConversion (
    @field:NotEmpty(message = "Should inform accessKey")
    val accessKey: String,

    @field:NotEmpty(message = "Should inform userId")
    val userId: UUID,

    @field:NotEmpty(message = "Should inform initialCoin")
    val initialCoin: String,

    @field:NotEmpty(message = "Should inform initialValue")
    val initialValue: Double,

    @field:NotEmpty(message = "Should inform finalCoin")
    val finalCoin: String)


data class ResponseConversionRate (val success: Boolean,
                                   val timestamp: Timestamp,
                                   val base: String,
                                   val date: Date,
                                   val rates: Map<String, Double>)

data class ResponseCoinConversion (val transactionId: UUID?,
                                   val userId: UUID,
                                   val initialCoin: String,
                                   val initialValue: Double,
                                   val finalCoin: String,
                                   val finalValue: Double,
                                   val conversionRate: Double)
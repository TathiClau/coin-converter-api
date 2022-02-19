package com.api.CoinConverter.domain

import java.sql.Timestamp
import java.util.*

data class AddCoinConversion (val accessKey: String,
                              val userId: UUID,
                              val initialCoin: String,
                              val initialValue: Double,
                              val finalCoin: String)


data class ResponseConversionRate (val success: Boolean,
                                   val timestamp: Timestamp,
                                   val base: String,
                                   val date: Date,
                                   val rates: Map<String, Double>)


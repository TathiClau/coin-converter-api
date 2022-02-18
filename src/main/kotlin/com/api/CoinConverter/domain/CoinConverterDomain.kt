package com.api.CoinConverter.domain

import java.util.*



data class AddCoinConversion (val accessKey: String,
                              val userId: UUID,
                              val initialCoin: String,
                              val initialValue: Double,
                              val finalCoin: String)


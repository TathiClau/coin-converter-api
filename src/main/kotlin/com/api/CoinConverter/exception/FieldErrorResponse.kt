package com.api.CoinConverter.exception

data class FieldErrorResponse (
    var message: String,
    var field: String
)
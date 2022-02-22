package com.api.CoinConverter.exception

class BadRequestException(override val message: String, val errorCode: String) : Exception() {
}
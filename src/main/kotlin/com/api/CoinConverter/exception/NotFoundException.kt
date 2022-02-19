package com.api.CoinConverter.exception

class NotFoundException(override val message: String, val errorCode: String): Exception() {
}
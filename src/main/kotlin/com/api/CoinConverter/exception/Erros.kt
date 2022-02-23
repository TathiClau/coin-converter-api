package com.api.CoinConverter.exception

enum class Erros(val code: String, val message: String) {

    ML101("ML-101", "Transaction [%s] was not found"),
    ML001("ML-001", "Invalid Request"),
}

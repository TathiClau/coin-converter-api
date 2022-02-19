package com.api.CoinConverter.service

import com.api.CoinConverter.domain.AddCoinConversion
import com.api.CoinConverter.domain.ResponseCoinConversion
import com.api.CoinConverter.entity.Transaction
import com.api.CoinConverter.repository.TransactionRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CoinConverterService(val transactionRepository: TransactionRepository,
                        val coinConverterService: CoinRatesService) {

    fun postConvertedValue(addCoinConversion: AddCoinConversion): ResponseEntity<Transaction> {
        val rates = coinConverterService.getConversionRate(addCoinConversion.accessKey, addCoinConversion.initialCoin)
        val conversionRate = rates?.rates?.filterKeys { it == addCoinConversion.finalCoin }

        val finalValue = (conversionRate!!.values.firstNotNullOf { it }) * (addCoinConversion.initialValue)
        val trans = ResponseCoinConversion(null,
            addCoinConversion.userId,
            addCoinConversion.initialCoin,
            addCoinConversion.initialValue,
            addCoinConversion.finalCoin,
            finalValue,
            conversionRate.values.firstNotNullOf { it })

        val transactionResponse = transactionRepository.save(Transaction.toTransaction(trans))
        return ResponseEntity(transactionResponse, HttpStatus.OK)
    }
}
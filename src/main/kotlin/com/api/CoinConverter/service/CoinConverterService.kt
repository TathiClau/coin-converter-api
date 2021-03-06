package com.api.CoinConverter.service

import com.api.CoinConverter.domain.AddCoinConversion
import com.api.CoinConverter.domain.ResponseCoinConversion
import com.api.CoinConverter.entity.Transaction
import com.api.CoinConverter.exception.Erros
import com.api.CoinConverter.exception.NotFoundException
import com.api.CoinConverter.repository.TransactionRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*


@Service
class CoinConverterService(val transactionRepository: TransactionRepository,
                           val coinRatesService: CoinRatesService) {


    fun postConvertedValue(addCoinConversion: AddCoinConversion): ResponseEntity<Transaction> {
        val rates = coinRatesService.getConversionRate(addCoinConversion.accessKey, addCoinConversion.initialCoin)
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

    fun findAll(): List<Transaction> {
        return transactionRepository.findAll()
    }

    fun findById(id: UUID): Transaction? {
       return transactionRepository.findById(id).orElseThrow{ NotFoundException(Erros.ML101.message.format(id), Erros.ML101.code) }
    }


}
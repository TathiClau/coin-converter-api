package com.api.CoinConverter.controller

import com.api.CoinConverter.domain.AddCoinConversion
import com.api.CoinConverter.entity.Transaction
import com.api.CoinConverter.repository.TransactionRepository
import com.api.CoinConverter.service.CoinConverterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["/coinconverter"])
class CoinConverterController (val coinConverterService: CoinConverterService,
                               val transactionRepository: TransactionRepository
) {

    //Endpoint that list all transactions
    @GetMapping(value = ["/transactions"])
    fun findAll(): List<Transaction> {
        return transactionRepository.findAll()
    }

    //Endpoint that list a transaction by Id
    @GetMapping(value = ["/transactionsById"])
    fun findById(@RequestParam("id") id: UUID): Optional<Transaction> {
        return transactionRepository.findById(id)
    }

    //Endpoint for post on the database the transaction that has being made and return the coin conversion
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun coinConverter(@RequestBody addCoinConversion: AddCoinConversion): ResponseEntity<Transaction> {
        return coinConverterService.postConvertedValue(addCoinConversion)
    }

}
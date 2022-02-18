package com.api.CoinConverter.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping(value = ["/coinconverter"])
class CoinConverterController {

    //Endpoint that list all transactions
    @GetMapping(value = ["/transactions"])
    fun findAll(): Unit {
        return
    }

    //Endpoint that list a transaction by Id
    @GetMapping(value = ["/transactionsById"])
    fun findById(@RequestParam("id") id: UUID): Unit {
        return
    }

    //Endpoint for post on the database the transaction that has being made and return the coin conversion
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun coinConverter(@RequestBody addCoinConversion: AddCoinConversion): Unit {
        return
    }

}
package com.api.CoinConverter.service

import com.api.CoinConverter.helper.*
import com.api.CoinConverter.repository.TransactionRepository
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*


@ExtendWith(MockKExtension::class)

class CoinConverterServiceTest {
    @MockK
    private lateinit var transactionRepository: TransactionRepository

    @MockK
    private lateinit var coinRatesService: CoinRatesService

    @InjectMockKs
    @SpyK
    private lateinit var coinConverterService: CoinConverterService

    @Test
    fun `should return all transactions`() {
        val fakeTransactions = listOf(buildTransaction(), buildTransaction())

        every { transactionRepository.findAll() } returns fakeTransactions

        val transactions = coinConverterService.findAll()

        assertEquals(fakeTransactions, transactions)
        verify(exactly = 1) { transactionRepository.findAll() }
    }

    @Test
    fun `should return transaction when id is informed`() {
        val id = UUID.randomUUID()
        val fakeTransaction = Optional.ofNullable(buildTransaction())

        every { transactionRepository.findById(id) } returns fakeTransaction
        val transaction = coinConverterService.findById(id)

        assertEquals(fakeTransaction, Optional.ofNullable(transaction))
        verify(exactly = 1) { transactionRepository.findById(id) }

    }

    @Test
    fun `should create transaction`() {
        val fakeTransaction = buildTransaction()
        val fakeAddCoinConvertion = buildAddCoinConversion()
        val fakeConvertionRate = buildResponseConversionRate()

        every { transactionRepository.save(fakeTransaction) } returns fakeTransaction
        every { coinRatesService.getConversionRate(fakeAddCoinConvertion.accessKey, fakeAddCoinConvertion.initialCoin) } returns fakeConvertionRate

        val addTransaction = coinConverterService.postConvertedValue(fakeAddCoinConvertion)

        assertEquals(fakeTransaction, addTransaction)
        verify(exactly = 1) { transactionRepository.save(fakeTransaction) }
        verify(exactly = 1) { coinRatesService.getConversionRate(fakeAddCoinConvertion.accessKey, fakeAddCoinConvertion.initialCoin) }
    }


}




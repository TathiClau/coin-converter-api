package com.api.CoinConverter.service

import com.api.CoinConverter.helper.buildTransaction
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
        
    }




}
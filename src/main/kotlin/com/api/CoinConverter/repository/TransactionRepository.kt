package com.api.CoinConverter.repository

import com.api.CoinConverter.entity.Transaction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TransactionRepository : CrudRepository<Transaction, UUID> {
    override fun findAll(): List<Transaction>
    override fun findById(id: UUID): Optional<Transaction>
}
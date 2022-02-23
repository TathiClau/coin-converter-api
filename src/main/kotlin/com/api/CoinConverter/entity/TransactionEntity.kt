package com.api.CoinConverter.entity

import com.api.CoinConverter.domain.ResponseCoinConversion
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TRANSACTION")
class Transaction {

    @Column(name = "ID")
    @Id
    var id: UUID? = null

    @PrePersist
    fun generateId() {
        this.id = UUID.randomUUID()
    }

    @Column(name = "USER_ID")
    var userId: UUID? = null

    @Column(name = "INITIAL_COIN")
    var initialCoin: String? = null

    @Column(name = "INITIAL_VALUE")
    var initialValue: Double? = null

    @Column(name = "FINAL_COIN")
    var finalCoin: String? = null

    @Column(name = "FINAL_VALUE")
    var finalValue: Double? = null

    @Column(name = "CONVERSION_RATE")
    var conversionRate: Double? = null

    @Column(name = "TRANSACTION_DATE")
    var transactionDate: LocalDateTime? = null

    companion object {
        fun toTransaction(
            responseCoinConversion: ResponseCoinConversion
        ): Transaction {
            val transaction = Transaction()
            transaction.id = UUID.randomUUID()
            transaction.userId = responseCoinConversion.userId
            transaction.initialCoin = responseCoinConversion.initialCoin
            transaction.initialValue = responseCoinConversion.initialValue
            transaction.finalCoin = responseCoinConversion.finalCoin
            transaction.finalValue = responseCoinConversion.finalValue
            transaction.conversionRate = responseCoinConversion.conversionRate
            transaction.transactionDate = LocalDateTime.now()
            return transaction
        }
    }
}
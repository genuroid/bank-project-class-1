package com.example.bankacc


open class Account(val accountNumber: String, val ownerName: String) {

    private var balance: Double = 0.0   // encapsulated balance

    fun getBalance(): Double
    {
        return balance
    }

    fun deposit(amount: Double)
    {
        if (amount > 0)
        {
            balance += amount
            println("Deposit successful. Amount: $amount")
        } else
        {
            println("Deposit failed. Invalid amount.")
        }
    }

    open fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount)
        {
            balance -= amount
            println("Withdraw successful. Amount: $amount")
        } else
        {
            println("Withdraw failed. Insufficient funds.")
        }
    }

    fun printInfo()
    {
        println("Account Number: $accountNumber")
        println("Owner Name: $ownerName")
        println("Balance: $balance")
        println("----------------------")
    }
}

// Savings account
class SavingsAccount(accountNumber: String, ownerName: String)
    : Account(accountNumber, ownerName)
{

    override fun withdraw(amount: Double)
    {
        if (amount > 500)
        {
            println("Withdrawal limit exceeded. Max 500 per transaction.")
        } else
        {
            super.withdraw(amount)
        }
    }
}

// VIP account
class VIPAccount(accountNumber: String, ownerName: String, val transactionFee: Double = 2.0)
    : Account(accountNumber, ownerName)
{

    override fun withdraw(amount: Double)
    {
        val totalAmount = amount + transactionFee
        if (getBalance() >= totalAmount)
        {
            println("Withdrawal: $amount + fee: $transactionFee")
            super.withdraw(totalAmount)
        } else
        {
            println("Withdraw failed. Not enough balance including fee.")
        }
    }
}

// Testing the classes

fun main()
{
    val savings = SavingsAccount("S101", "George G.")
    val vip = VIPAccount("V202", "Mariam A.")

    // Deposits
    savings.deposit(1000.0)
    vip.deposit(1000.0)

    // Test withdrawals
    println("\n--- Savings Account Test ---")
    savings.withdraw(600.0)  // should fail
    savings.withdraw(400.0)  // should work

    println("\n--- VIP Account Test ---")
    vip.withdraw(300.0)  // should apply fee

    // Print info
    println("\n--- Final Info ---")
    savings.printInfo()
    vip.printInfo()
}

package org.codefx.demo.bingen.bank

/*
 * TODO #3: Use the bank
 *
 * Create a bank, some customers, and accounts and transfer some money back and forth.
 */

// all the following code was added in order to solve TODO #3

fun main (args: Array<String>){

    // Cration of the Iron Bank
    val bank_ironBank : Bank = Bank()

    // A new customer arrives and brings some money with him
    val customer_1 : Customer = bank_ironBank.newCustomer ("Bill Gates")
    bank_ironBank.deposit(customer_1.defaultAccount , Money (125699187))

    // A new customer arrives and needs some money to withdraw. Therefore the limit must be adapted.
    val customer_2 : Customer = bank_ironBank.newCustomer("Boris Becker")
    bank_ironBank.bank_setNewLimit(customer_2.defaultAccount , Balance (5000))
    bank_ironBank.withdraw(customer_2.defaultAccount , Money (4000))

    // A new customer arrives and brings some money with him. He wants two accounts
    val customer_3 : Customer = bank_ironBank.newCustomer ("Ulli Hoeneß")
    bank_ironBank.deposit(customer_1.defaultAccount , Money (2000))
    val cust3SecondAcc : Account = bank_ironBank.openAccount(customer_3 , Money(2000))

    // Some money is transferred
    bank_ironBank.transferBetweenCustomers(customer_1 , customer_2 , Money (8000))
    bank_ironBank.transferBetweenCustomers(customer_2 , customer_3 , Money (7000))
    bank_ironBank.transferBetweenAccounts(customer_3.defaultAccount , cust3SecondAcc , Money(4500))
    

}


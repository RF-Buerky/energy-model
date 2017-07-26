package org.codefx.demo.bingen.bank

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Assert.assertEquals
import org.junit.Test

class BankTest {

    val bank = Bank()

    // OPENING / CLOSING

    /*
     * TODO #1: fix tests
     *
     * Some tests fail - change the code (note the test code!) to make them pass.
     */

    @Test
    fun newCustomerMustHaveAccount() {
        val john = bank.newCustomer("John Doe")
        assertFalse(john.accounts.isEmpty())
    }

    @Test
    fun newAccountMustBelongToCustomer() {
        val john = bank.newCustomer("John Doe")
        val account = bank.openAccount(john)

        assertTrue(john.accounts.contains(account))
    }

    @Test
    fun newAccountMustContainOpeningDeposit() {
        val john = bank.newCustomer("John Doe")
        val account = bank.openAccount(john, openingDeposit = Money(100))

        assertTrue(bank.balance(account) == Balance(100))
    }

    @Test
    fun closingAccountPaysOutAllMoney() {
        val john = bank.newCustomer("John Doe")
        val account = bank.openAccount(john, openingDeposit = Money(150))

        assertTrue(bank.closeAccount(john, account) == Money(150))
    }

    @Test
    fun closingOverdrawnAccountPaysOutNoMoney() {
        val john = bank.newCustomer("John Doe")
        val account = bank.openAccount(john, openingDeposit = Money(100), limit = Balance(-100))
        bank.withdraw(account, Money(150))

        assertTrue(bank.closeAccount(john, account) == Money(0))
    }

    // The following test was made in order to solve TODO #2
    // test if depositing money works
    @Test
    fun depositingMoney1() {
        val john = bank.newCustomer("John Doe")
        val account = bank.openAccount(john, openingDeposit = Money(100), limit = Balance(-100))
        bank.deposit(account , Money(80))
        val x = account.balance

        assertEquals(Balance(180) , x)
    }

    // The following test was made in order to solve TODO #2
    // test if withdrawing money works
    @Test
    fun withdrawingMoney1() {
        // withdrawing without overdrawing
        val john = bank.newCustomer("John Doe")
        val account = bank.openAccount(john, openingDeposit = Money(100), limit = Balance(-100))
        bank.withdraw(account , Money(80))
        val x = account.balance

        assertEquals(Balance(20) , x)
    }

    // The following test was made in order to solve TODO #2
    // test if withdrawing money works
    @Test
    fun withdrawingMoney2() {
        // withdrawing with overdrawing but within the limits borders
        val john = bank.newCustomer("John Doe")
        val account = bank.openAccount(john, openingDeposit = Money(1000), limit = Balance(-100))
        bank.withdraw(account , Money(1020))
        val x = account.balance

        assertEquals(Balance(-20) , x)
    }

    // The following test was made in order to solve TODO #2
    // test if withdrawing money works
    @Test
    fun withdrawingMoney3() {
        // withdrawing attemp to withdraw more as the limit should allow
        val john = bank.newCustomer("John Doe")
        val account = bank.openAccount(john, openingDeposit = Money(100), limit = Balance(-100))
        bank.withdraw(account , Money(500))
        val x = account.balance

        assertEquals(Balance(100) , x)
    }

    // The following test was made in order to solve TODO #2
    // test if transferring money between accounts works
    @Test
    fun transferringMoneyBetweenAccounts1() {
        val john = bank.newCustomer("John Doe")
        val accountA = bank.openAccount(john, openingDeposit = Money(500), limit = Balance(-100))
        val bob = bank.newCustomer("Bob Builder")
        val accountB = bank.openAccount(bob, openingDeposit = Money(-100), limit = Balance(-5000))

        bank.transferBetweenAccounts(from = accountB , to = accountA , amount = Money(3000))

        val a = accountA.balance
        val b = accountB.balance

        assertEquals(Balance(3500) , a)
        assertEquals (Balance (-3100) , b)
    }

    // The following test was made in order to solve TODO #2
    // test if transferring money between customers works
    @Test
    fun transferringMoneyBetweenCustomers1() {
        val john = bank.newCustomer("John Doe")
        bank.deposit(john.defaultAccount , Money(800))
        val bob = bank.newCustomer("Bob Builder")
        bank.deposit(bob.defaultAccount , Money(20))

        val a = john.defaultAccount.balance
        val b = bob.defaultAccount.balance

        assertEquals(Balance(800) , a)
        assertEquals (Balance (20) , b)

        bank.transferBetweenCustomers(from = john , to = bob , amount = Money(300))

        val a2 = john.defaultAccount.balance
        val b2 = bob.defaultAccount.balance

        assertEquals(Balance(500) , a2)
        assertEquals (Balance (320) , b2)
    }


    // TRANSFERRING

    /*
     * TODO #2: write tests
     *
     * Verify that:
     *  - depositing money works
     *  - withdrawing money works
     *  - transferring money between accounts works
     *  - transferring money between customers works
     *
     *  If some new tests fail, fix the code to make them pass
     */

}

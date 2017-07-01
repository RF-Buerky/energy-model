package org.codefx.demo.bingen.energy_model

class Account(var balance: Int, var limit: Int) {

    fun deposit(amount: Int): Int {
        // _________________________________________________________________________________
        // The following lines show the original code commented out. There have been done mistakes
        // py purpose to make the test in the test file "AccountTest" fail. The code had to
        // be improved in order to make the tests pass. The improved code is added after the
        // original code.
        // _________________________________________________________________________________
        /*
        balance += amount
        return amount
        */

        // _________________________________________________________________________________
        // The following lines show the improved code. The improvements have been done by
        // viewing the functions in the test file "AccountTest".
        // _________________________________________________________________________________

        // Referring to the function "negativeDepositDoesNotChangeBalance()", there should be no
        // incident on the balance if a negative amount is about to get deposit. This is a plausible
        // way as it is not possible to deposit a negative amount of money onto your bank account.
        // The equivalent way would be to withdraw the (positive) amount of money. So this is the way
        // we are going here, also.
        if (amount < 0){
            val deposited : Int = 0
            return deposited
        } else {
            balance = balance + amount
            return balance
        }

    }

    fun withdraw(amount: Int): Int {
        if (balance >= amount) {
            // balance suffices, pay out the money
            balance -= amount
            return amount
        } else {
            // insufficient balance; pay out 0
            return 0
        }
    }

    fun currentBalance(): Int {
        return balance
    }

}

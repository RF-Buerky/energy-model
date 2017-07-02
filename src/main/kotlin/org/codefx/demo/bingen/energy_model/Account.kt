package org.codefx.demo.bingen.energy_model

class Account(var balance: Int, var limit: Int) {


    // _________________________________________________________________________________
    // The following lines show the original code commented out. There have been done mistakes
    // py purpose to make the tests in the test file "AccountTest" fail. The code had to
    // be improved in order to make the tests pass. The improved code is added after the
    // original code.
    // _________________________________________________________________________________
    /*
    fun deposit(amount: Int): Int {
        balance += amount
        return amount
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
    fun deposit(amount: Int): Int {
        var depositedAmount : Int
        if (amount < 0){
            depositedAmount = 0
            balance = balance
        } else {
            depositedAmount = amount
            balance = balance + amount
        }
        return depositedAmount
    }

    // _________________________________________________________________________________
    // Referring to the function "negativeWithdrawalDoesNotChangeBalance()", there should be no
    // incident on the balance if a negative amount is about to get withdrawn. This is a plausible
    // way as it is not possible to withdraw a negative amount of money by your bank account.
    // The equivalent way would be to deposit the (positive) amount of money. So this is the way
    // we are going here, also.
    fun withdraw(amount: Int): Int {
        var withdrawedAmount : Int

        if (amount < 0) {
            withdrawedAmount = 0
            balance = balance
        } else if (balance - amount >limit) {
                // balance suffices, pay out the money
            withdrawedAmount = amount
            balance = balance - amount
        } else {
            withdrawedAmount = 0
            balance = balance
        }
        return withdrawedAmount
        }


    fun currentBalance(): Int {
        return balance
    }

}

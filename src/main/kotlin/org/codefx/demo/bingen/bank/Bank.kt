package org.codefx.demo.bingen.bank

class Bank {

    /*
     * TODO #4: improve [Bank]
     *
     * Currently the bank hands out accounts (e.g. [openAccount] returns an [Account]).
     * That's weird because it allows customers to interact directly with the account
     * without going through the bank.
     *
     * Instead of acting on [Account] entities all methods should receive and return
     * [AccountNumber] values (i.e. data classes). Before starting to write any code
     * consider carefully:
     *
     *  - what should the [AccountNumber] value class have as fields
     *    (think about what your account number looks like but keep it simple)
     *  - who needs to know about the account numbers? the account? the customer? the bank?
     *  - given an account number how does the bank get the corresponding account
     *    (two ideas: collect all accounts in a map[1] or put them all in the list
     *    and search through that)
     *  - if you have any problems, open a PR with what you have
     *
     * [1] https://www.youtube.com/watch?v=FUqD6srpuPY
     */

    val customers: MutableList<Customer> = mutableListOf()

    fun openAccount(customer: Customer, openingDeposit: Money = Money(0), limit: Balance = Balance(0)): Account {
        if (!customers.contains(customer)) {
            println("!! CUSTOMER DOES NOT BELONG TO THIS BANK")
        }

        // The following line needet to be changed in order to solve TODO #1
        // old version of line:
        /*
        val newAccount = Account()
         */
        // New version of line:
        val newAccount = Account(limit = limit)

        customer.accounts.add(newAccount)

        // The following line needet to be added in order to solve TODO #1
        deposit (newAccount , openingDeposit)

        // The following line needet to be added in order to solve TODO #1
        /*
           bank_setNewLimit(newAccount , limit)
         */
        // A better way was found instead of using this function. Just implement the limit inside
        // the declaration of the new Account
        // Changing 'val newAccount = Account()' into 'val newAccount = Account(limit = limit)

        return newAccount
    }

    fun closeAccount(customer: Customer, account: Account): Money {
        if (!customers.contains(customer)) {
            println("!! CUSTOMER DOES NOT BELONG TO THIS BANK")
            return Money(0)
        }
        else if (account.balance.isOverdrawn()) {
            println("!! OVERDRAWN ACCOUNT CAN NOT BE CLOSED")
            return Money(0)
        } else {

            customer.accounts.remove(account)

            if (customer.accounts.isEmpty()) {
                customers.remove(customer)
            }

            return account.withdrawRemaining()
        }
    }

    fun newCustomer(name: String): Customer {
        val newAccount = Account()
        val newCustomer = Customer(name, newAccount)
        customers.add(newCustomer)
        return newCustomer
    }

    fun balance(account: Account): Balance {
        return account.balance
    }

    fun deposit(account: Account, amount: Money): Money {
        return account.deposit(amount)
    }

    fun withdraw(account: Account, amount: Money): Money {
        // The following code was wrong and has been corrected in order solve TODO #1
        // return account.deposit(amount)
        return account.withdraw(amount)
    }

    fun transferBetweenAccounts(from: Account, to: Account, amount: Money): Money {
        val withdrawnAmount = from.withdraw(amount)
        to.deposit(withdrawnAmount)
        // TODO: reporting
        return withdrawnAmount
    }

    fun transferBetweenCustomers(from: Customer, to: Customer, amount: Money): Money {
        val fromAccount = from.defaultAccount
        // There has been a mistake corrected by solving TODO #2
        val toAccount = to.defaultAccount
        return transferBetweenAccounts(fromAccount, toAccount, amount)
    }

    // The following function needet to be added in order to solve TODO #1
    fun bank_setNewLimit (account: Account , newLimit : Balance): Balance {
        return account.setNewLimit(newLimit)
    }
}

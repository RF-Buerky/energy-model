package org.codefx.demo.bingen.bank

class Customer(val name: String, var defaultAccount: Account) {

    val accounts: MutableList<Account> = mutableListOf()

    init {
        accounts.add(defaultAccount)
    }

    override fun toString(): String {
        return "Customer('$name', defaultAccount=$defaultAccount)"
    }

}

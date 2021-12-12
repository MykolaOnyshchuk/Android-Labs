package com.example.lab1kotlin

class Calculation {
    private var firstValue = 0
    private var secondValue = 0
    private var operation = ""
    private var result = 0

    fun Calculation(firstVal: Int, secondVal: Int, oper: String, res: Int) {
        firstValue = firstVal
        secondValue = secondVal
        operation = oper
        result = res
    }

    fun getFirstValue(): Int {
        return this.firstValue
    }

    fun getSecondValue(): Int {
        return this.secondValue
    }

    fun setValues(firstValue: Int, secondValue: Int) {
        this.firstValue = firstValue
        this.secondValue = secondValue
    }

    fun getOperation(): String {
        return this.operation
    }

    fun setOperation(operation: String) {
        this.operation = operation
    }

    fun getResult(): Int {
        return this.result
    }

    fun setOperation(result: Int) {
        this.result = result
    }
}
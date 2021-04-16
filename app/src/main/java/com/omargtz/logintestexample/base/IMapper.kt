package com.omargtz.logintestexample.base


abstract class IMapper<I, O> {
    abstract fun map(input: I): O

    fun mapList(inputs: MutableList<I>): MutableList<O>? {
        val returnValues = mutableListOf<O>()
        for (input in inputs) {
            returnValues.add(map(input))
        }
        return returnValues
    }
}
package com.example.lab3david

/*
    David Cho
    A01351217
 */

fun main() {

    yearFactMap.forEach { (key, value) -> println("$key=$value") }
    println("")
    // anonymous function
    println(anonFunction(1492, yearFactMap))
    // lambda function
    println(lambdaFunction(yearFactMap)[1])
    // function argument
    functionArg(::getFact, yearFactMap[1632] ?: "No fact found")
    // function reference
    val functionRef = ::getFact
    functionRef(yearFactMap[1838] ?: "No fact found")
    // function literal
    functionLiteral(::getFact)(yearFactMap[2020] ?: "No fact found")

}

val yearFactMap = mapOf(
    1492 to "Christopher Columbus discovers America",
    1601 to "William Shakespeare writes Hamlet",
    1632 to "Galileo discovered the acceleration of gravity on Earth to be 9.8m/s",
    1838 to "Roughly 9.46 trillion km, the light-year is first used as a measurement in astronomy",
    2020 to "Covid 19 Pandemic"
)

//No two functions can have the same signature (combination of parameters and return types)

// display value using key
fun getFact(value: String) {
    println(value)
}

// anonymous function
val anonFunction = fun(key: Int, map: Map<Int, String>): String {
    return map.getOrDefault(key, "No key found")
}

// lambda function
val lambdaFunction: (map: Map<Int, String>) -> List<String> = { it -> it.values.toList() }

// function argument
fun functionArg(function: (String) -> Unit, value: String) {
    function(value)
}

// function literal
val functionLiteral = { function: (String) -> Unit ->
    { value: String ->
        function(value)
    }
}

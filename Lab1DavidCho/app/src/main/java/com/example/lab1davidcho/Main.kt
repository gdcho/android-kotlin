package com.example.lab1davidcho

/*
    David Cho
    A01351217
 */

const val VERSION_NUM = 1.2
const val SLOGAN = "deliver with a smile"

fun main(){

    var streetNUM = 123
    var streetName = "loch ness road"

    var str1 = """
        Starting beta version...
        ...
        ...
        ...
    """.trimIndent()

    val fullAddress:String? = if(VERSION_NUM >= 1){
        "%d %s, Glasgow, Scotland".format(streetNUM, streetName.lowercase())
    } else{
        println(str1)
        null
    }
    var str2 = """
        
                  Food Delivery Service v $VERSION_NUM 
        
       Welcome to Glasgow's finest food delivery service, where we provide
       you with swift instructions on where to deliver your food.
 
                  Please deliver the food to:
            
                  ${fullAddress?.uppercase()}
            
       Your hard work and commitment to delivering food are
       always appreciated, and never forget..${SLOGAN.uppercase()}.
       
       ...Thank you.
    """.trimIndent()

    println(str2)
}
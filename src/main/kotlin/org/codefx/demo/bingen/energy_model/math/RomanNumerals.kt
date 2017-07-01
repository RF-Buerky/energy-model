package org.codefx.demo.bingen.energy_model.math

// The figures for Roman Numerals are:
// I for 1
// V for 5
// X for 10
// L for 50
// C for 100

val i : Int = 1
val v : Int = 5
val x : Int = 10
val l : Int = 50
val c : Int = 100


fun asRoman(n: Int): String {
    var isToBig : Boolean = false
    var isToSmall : Boolean = false
    var ausgabe : String = "null"


    if (n > 3*l){
        isToBig = true
    }

    if (n >= 1*l && n <= 3*l){
        var ausgabe_L : String = "null_L"
        when (n){
            150 -> ausgabe_L = "LLL"
            in 100..149 -> ausgabe_L = "LL"
            else -> ausgabe_L = "L"

        }
    } else if (n >= 3*x  3*x){
        var ausgabe_X : String = "null_X"

    }
    var rest : Int = n
    if (rest >= 1*x && rest <= 3*x){
        var ausgabe_X : String = "null_X"

    }
    else if ((rest > 3*i) && (rest  <= 3*v)){
        var ausgabe_v : String = "null_v"

    }
    else if ((rest / i) >= 1 && (rest / i) <= 3){
        var ausgabe_i : String = "null_i"
        when (rest){
            1 -> ausgabe_i = "I"
            2 -> ausgabe_i = "II"
            3 -> ausgabe_i = "III"
        }

    }
    else {
        ausgabe = "Fehler! Nur positive Zahlen!"
    }
    ausgabe.

    if (isToBig || isToSmall){
        ausgabe = "Nur zahlen zwischen 1 und 150 möglich!"
    }
    return ausgabe
}

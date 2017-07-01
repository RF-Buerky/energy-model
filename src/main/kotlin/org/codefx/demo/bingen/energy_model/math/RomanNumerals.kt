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
    var ausgabe : String = ""


    if (n > 3*l){
        isToBig = true
    } else if (n < 1*i){
        isToSmall = true
    }

    var rest : Int = n

    while (rest != 0){
        while (rest >= l){
            ausgabe = ausgabe + "L"
            rest = rest - l
        }

        while (rest >= x){
            ausgabe = ausgabe + "X"
            rest = rest - x
        }

        while (rest >= v){
            ausgabe = ausgabe + "V"
            rest = rest - v
        }
    }



    if (isToBig || isToSmall){
        ausgabe = "Nur zahlen zwischen 1 und 150 möglich!"
    }
    return ausgabe
}

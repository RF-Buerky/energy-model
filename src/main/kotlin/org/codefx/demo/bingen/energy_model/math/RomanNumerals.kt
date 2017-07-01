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
    var ausgabe_korrigiert : String = ""

    // At first here we get a String with always the highest number possible. The rule to not make an addition
    // of four identical figures is not faced here. We do this later.

    if (n > 89){
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

        while (rest >= i){
            ausgabe = ausgabe + "I"
            rest = rest - i
        }
    }


    if (isToBig || isToSmall){
        ausgabe = "Nur zahlen zwischen 1 und 89 möglich!"
    }

    // Now we face the rule of no addition with four ore more identical figures along side.
    // We solve this problem by replacing pairs of four by their equivalent as the rules are
    // demanding.

    ausgabe_korrigiert = ausgabe.replace("VIIII" , "IX").replace("IIII" , "IV").replace("XVVVV" , "XXL")
            .replace("XXXX" , "XL")

    return ausgabe_korrigiert
}

package com.example.moodfood.chrapka

import java.lang.Exception
import java.lang.StringBuilder
import java.sql.DriverManager
import java.util.*

class MakeRecipe {
    private var recipeCode = ""
    fun makeSqlQuery(args: Array<String>?): String? {
        // podstawa komendy SQL
        val sqlCommand = StringBuilder("SELECT id FROM skladniki WHERE ")
        if (args != null) {         // sprawdza czy tablica nie jest pusta
            val gotoweSkladniki =
                arrayOfNulls<String>(args.size) // utworzenie nowej tablicy, ktora bedzie miala skladniki napisane mala litera
            var i = 0 //  iterator
            for (skladnik in args) {  //  petla w ktorej z tablicy w przeslanej w argumencie metody skopiuja sie elementy i zostana zapisane w tablicy gotoweSkladniki
                gotoweSkladniki[i] = skladnik.toLowerCase(Locale.ROOT) //  przypisane i konwersja znakow na male litery
                i++
            }
            i = 0
            while (i < gotoweSkladniki.size) {
                // petla w ktorej dodamy skladniki do komendy SQL
                if (i == 0) sqlCommand.append("nazwa='").append(gotoweSkladniki[i])
                    .append("'") //  pierwszy element nie potrzebuje OR w komendzie
                else sqlCommand.append(" OR nazwa='").append(gotoweSkladniki[i])
                    .append("'") //  kazdy nastepny element bedzie poprzedzony slowem kluczowym OR
                i++
            }
        }
        return sqlCommand.toString()
    }

    fun makeRecipeCode(args: Array<String>) {
        val adres = "jdbc:mysql://localhost/moodfood"
        val dane = "root"
        try {
            Class.forName("com.mysql.jdbc.Driver")
            val con = DriverManager.getConnection(adres, dane, dane)
            val st = con.createStatement()
            val wyniki = st.executeQuery(makeSqlQuery(args))
            val idSkladnikow = IntArray(args.size)
            var i = 0
            while (wyniki.next()) {
                idSkladnikow[i] = wyniki.getInt(1)
                i++
            }
            con.close()
            Arrays.sort(idSkladnikow)
            val kod = StringBuilder()
            for (id in idSkladnikow) {
                if (id == 0) continue
                kod.append(id).append("-")
            }
            recipeCode = kod.toString()
        } catch (e: Exception) {
            println(e.toString())
        }
    }

    fun MakeRecipe(args: Array<String>) {
        makeRecipeCode(args)
    }

    override fun toString(): String {
        return recipeCode
    }
}
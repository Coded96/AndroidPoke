package com.example.conversor.utils

import android.text.Editable
import com.example.conversor.activities.ConversorActivity

class Conversores{

    companion object {
        enum class TipoConversion(valor: String) {
            Euro("Euro"),
            Dolar("Dolar"),
            Libra("Libra"),
            PesoMexicano("Peso mexicano"),
            Yen("Yen"),
            Yuan("Yuan")
        }
        
        /*  Conversión del primer valor al segundo  */
        fun convertirEuro(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString()
                    if (input.isNotEmpty() && input.matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = input
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 1.09
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.86
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 18.71
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 157.12
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 7.85
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
            }
            return convertedValue
        }
    
        fun convertirDolar(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.91
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.79
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 17.16
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 143.71
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 7.18
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun convertirLibra(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 1.16
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 1.27
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 21.82
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 182.69
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 9.13
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun convertirPesoMexicano(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.053
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.058
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.046
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 8.37
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.42
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun convertirYen(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.0064
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.007
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.0055
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.12
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.05
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun convertirYuan(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.13
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.14
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.11
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 2.39
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 20.02
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        /*  Conversión del segundo valor al primero  */
        public fun reconvertirEuro(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 1.09
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.86
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 18.71
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 157.12
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 7.85
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun reconvertirDolar(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.91
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.79
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 17.16
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 143.71
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 7.18
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun reconvertirLibra(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 1.16
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 1.27
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 21.82
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 182.69
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 9.13
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun reconvertirPesoMexicano(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.053
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.058
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.046
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 8.37
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.42
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun reconvertirYen(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.0064
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.007
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.0055
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.12
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yuan -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.05
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    
        public fun reconvertirYuan(s: Editable, item: Any): String {
            var convertedValue = ""
            when (item) {
                TipoConversion.Euro -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.13
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Dolar -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.14
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.Libra -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 0.11
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
                }
    
                TipoConversion.PesoMexicano -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 2.39
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                TipoConversion.Yen -> {
                    val input = s.toString().toDoubleOrNull()
                    var valor = 0.0
                    if (input != null) valor = input.toDouble() * 20.02
    
                    if (valor.toString().isNotEmpty() && valor.toString().matches(Regex("-?\\d+(\\.\\d+)?"))) convertedValue = valor.toString()
    
                }
    
                else -> convertedValue = s.toString()
            }
            return convertedValue
        }
    }
}
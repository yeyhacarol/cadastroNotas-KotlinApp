package com.senai.controle_notas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //o R representa toda a pasta res.
        // Captura dos botões; armazenando os nas variáveis
        val calcular = findViewById<Button>(R.id.calcular)
        val sair = findViewById<Button>(R.id.sair)

        //inserindo listener no botão calcular
        calcular.setOnClickListener() {
            /*armazenando os elementos da view em variáveis locais. text não possui um método para ser diretamente transformado em int, então primeiro devemos
            torná-lo uma string e depois em um inteiro para que possamos realizar os cálculos*/
            val nota1 = findViewById<EditText>(R.id.nota1).text.toString().toInt()
            val nota2 = findViewById<EditText>(R.id.nota2).text.toString().toInt()
            val faltas = findViewById<EditText>(R.id.faltas).text.toString().toInt()
            val resultado = findViewById<TextView>(R.id.resultado)
            val media = (nota1 + nota2) / 2



            if (media >= 5) {
                resultado.text = "Nota 1: ${nota1}\nNota 2: ${nota2}\n" +
                        "Qtde. de faltas: ${faltas}\nMédia: ${media}\nSituação: Aprovado"

                resultado.setTextColor(Color.GREEN)
            } else {
                resultado.text = "Nota 1: ${nota1}\nNota 2: ${nota2}\n" +
                        "Qtde. de faltas: ${faltas}\nMédia: ${media}\nSituação: Reprovado"
                resultado.setTextColor(Color.RED)
            }

        }

        //inserindo um listener no botão para que a aplicação se feche ao clicarmos nele
        sair.setOnClickListener() {
            finish()
        }


    }
}
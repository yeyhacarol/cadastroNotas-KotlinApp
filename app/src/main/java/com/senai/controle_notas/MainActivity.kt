package com.senai.controle_notas

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//lateinit para que a variável não seja iniciada na instância e sim quando for agregada a ela um valor
private lateinit var nota1EditText: EditText
private lateinit var nota2EditText: EditText
private lateinit var nomeEditText: EditText

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
            torná-lo uma string e depois em um inteiro para que possamos realizar os cálculos, mas dessa maneira temos um bug do qual a aplicação se fecha
            se o botão for clicado com alguma caixa vazia*/
            nota1EditText = findViewById(R.id.nota1)/*.text.toString().toInt() */
            nota2EditText = findViewById(R.id.nota2)/*.text.toString().toInt() */
            nomeEditText = findViewById(R.id.nome)

            val resultadoTextView = findViewById<TextView>(R.id.resultado)

            //antes de tranformar a caixa em uma string e em um inteiro, devemos verificar se há algo na caixa de texto por isso chamamos a função validarCampos
            if (validarCampos()) {
                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()
                val nome = nomeEditText.text.toString()

                val media = calcularMedia(nota1, nota2)

                //variável responsável por chamar a activity desta tela para outra
                val intent = Intent(this, ResultadoActivity::class.java)
                //colocando as variáveis nos campos de texto da outra activity
                intent.putExtra("nome", nomeEditText.text.toString())
                intent.putExtra("nota1", nota1.toString())
                intent.putExtra("nota2", "${nota2}")
                intent.putExtra("media", media.toString())
                intent.putExtra("situacao", situacaoAluno(media))
                //comando para inicializar a outra activity
                startActivity(intent)

                //e há essa maneira, utilizando a função, mas não há como estilizar etc
//                resultadoTextView.text = situacaoAluno(media)

                //há essa maneira de validar
//                if (media >= 5) {
//                    resultadoTextView.text = "Nota 1: ${nota1}\nNota 2: ${nota2}\n" +
//                            "A média da ${nome} é: ${media}\nSituação: ${resp}"
//
//                    resultadoTextView.setTextColor(Color.GREEN)
//                } else {
//                    resultadoTextView.text = "Nota 1: ${nota1}\nNota 2: ${nota2}\n" +
//                            "Média: ${media}\nSituação: ${resp}"
//                    resultadoTextView.setTextColor(Color.RED)
//                }
            }

        }

        //inserindo um listener no botão para que a aplicação se feche ao clicarmos nele
        sair.setOnClickListener() {
            finish()
        }


    }

    //função para analisar se os campos estão vazios. Inicio dizendo que não há erros, em cada uma das condições altero o valor para false pois são erros
    private fun validarCampos(): Boolean {
        var noError = true
        if (nota1EditText.text.isBlank()) {
            nota1EditText.setError("Nota 1 vazia!")
            noError = false
        }
        if (nota2EditText.text.isBlank()) {
            nota2EditText.setError(("Nota 2 vazia!"))
            noError = false
        }
        if (nomeEditText.text.isBlank()) {
            nomeEditText.setError("Digite o nome!")
            noError = false
        }

        return noError
    }

//    private fun calcularMedia(nota1: Int, nota2: Int): Int {
//        return (nota1 + nota2) / 2
//    }
//  outra maneira mais simplificada de criar funções, am casos que há apenas uma linha de código
//    private fun calcularMedia(nota1: Int, nota2: Int): Int = (nota1 + nota2) / 2
//  arrow function estrutura
//    val calcularMedia = {nota1: Int, nota2: Int -> (nota1 + nota2) / 2}


}
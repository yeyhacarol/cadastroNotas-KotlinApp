package com.senai.controle_notas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //resgatando os elementos da tela e armazenando-os em variáveis
        val nomeTextView = findViewById<TextView>(R.id.nome)
        val nota1TextView = findViewById<TextView>(R.id.nota1)
        val nota2TextView = findViewById<TextView>(R.id.nota2)
        val mediaTextView = findViewById<TextView>(R.id.media)
        val situacaoTextView = findViewById<TextView>(R.id.situacao)
        //variável do tipo intent que resgata e armazena os valores da outra tela
        val intent: Intent = getIntent()

        val actionBar = supportActionBar
        actionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        //resgatando os valores da outra activity (MainActivity) e armazenando nas variáveis dessa activity para que sejam exibidas na tela nos determinados campos
        nomeTextView.text = intent.getStringExtra("nome")
        nota1TextView.text = intent.getStringExtra("nota1")
        nota2TextView.text = intent.getStringExtra("nota2")
        mediaTextView.text = intent.getStringExtra("media")
        situacaoTextView.text = intent.getStringExtra("situacao")
    }
}
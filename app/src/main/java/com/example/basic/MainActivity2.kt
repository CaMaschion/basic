package com.example.basic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //para ler esses parâmetros na tela2, devemos obter o objeto Intent que a invocou usando a propriedade intent, e, em seguida,
        //ler os parâmetros usando getStringExtra(String) e getIntExtra(String, int), respectivamente
        val nome = intent.getStringExtra("nome")
        val idade = intent.getIntExtra("idade", -1)
        val cliente = intent.getParcelableExtra<Cliente>("cliente")
        val pessoa =
            intent.getSerializableExtra("pessoa") as Pessoa? // 0 o objeto pessoa deve ser nulo
        textMessage.text =
            if (cliente != null) {
                getString(R.string.tela2_texto1, cliente.nome, cliente.codigo)
            } else if (pessoa != null) {
                getString(R.string.tela2_texto2, pessoa.nome, pessoa.idade)
            } else {
                getString(R.string.tela2_texto1, nome, idade)
        }
    }
}
package com.example.basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val buttonToast = findViewById<EditText>(R.id.editTexto) mesma coisa que embaixo

        buttonToast.setOnClickListener {
            val texto = editTexto.text.toString()
            Toast.makeText(this, texto, Toast.LENGTH_SHORT).show()
        }
        buttonTela2.setOnClickListener {
            //uma activity não tem acesso à instância de outra, então, se quisermos passar informações
//             de uma tela para outra, devemos fazê-lo por meio
//            de parâmentros adcionados ao objeto Intent
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("nome", "Camila")
            intent.putExtra("idade", 31)
            startActivity(intent)
            //para ler esses parâmetros na tela2, devemos obter o objeto Intent que a invocou usando a propriedade intent, e, em seguida,
            //ler os parâmetros usando getStringExtra(String) e getIntExtra(String, int), respectivamente
        }
        buttonParcel.setOnClickListener {
            val cliente = Cliente(1, "Camila")
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("cliente", cliente)
            startActivity(intent)
        }
        buttonSerializable.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("pessoa", Pessoa("Camila", 31))
            startActivity(intent)
        }
    }
}
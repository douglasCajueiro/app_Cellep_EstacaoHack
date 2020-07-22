package dev.douglas_cajueiro.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Recuperar o email via intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        // Acessar o sharedPreferences
        val minhasPrefs = getSharedPreferences(
            "cadastro-$email", Context.MODE_PRIVATE)

        //Recuperar os dados no arquivo de sharedPreferences
        // Exibir os dados na Activity
        val nome = minhasPrefs.getString("NOME", "Nenhum")
        val sobrenome = minhasPrefs.getString("SOBRENOME", "Nenhum")
        //

        txvNome.text = "$nome $sobrenome"
        txvEmail.text = minhasPrefs.getString("EMAIL", "Nenhum")
        txvGenero.text = minhasPrefs.getString("GENERO", "Nenhum")



        // Implementando botão Sair
        btnSair.setOnClickListener {
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finishAffinity()
        }



        // Implementar botão SITE CELLEP
        btnSite.setOnClickListener {
            val mIntent = Intent(this, WebActivity::class.java)
            startActivity(mIntent)
        }



    }
}
package dev.douglas_cajueiro.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        ///////////////////////////////// Spinner /////////////////////////////////
        // Criar uma lista de opções para o Spinner
        val listaGenero = arrayListOf(
            "Selecione o Gênero", "Feminino", "Masculino", "NB", "Prefiro não informar")

        // Criar um adaptador para o Spinner
        val generoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listaGenero)

        // Plugar o adaptador no Spinner
        spnGenero.adapter = generoAdapter
        ///////////////////////////////// Spinner /////////////////////////////////


        ///////////////////////////// Botão Cadastrar ///////////////////////////// INICIO

        // Escutando o botão btnCadastrar
        btnCadastrar.setOnClickListener{

            // Recuperar os dados digitados
            val nome = edtNome.text.toString().trim()
            val sobrenome = edtSobrenome.text.toString().trim()
            val senha = edtSenha.text.toString().trim()
            val email = edtEmail.text.toString()

            // Atribuição condicional
            var genero = if(spnGenero.selectedItemId.toInt() >0) {
                spnGenero.selectedItem.toString()
            } else {
                ""
            }

            // Validação dos dados
            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty() || genero.isEmpty()) {

                //Retornando mensagem de erro
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {

                //////////////////// Configurando o SharedPreferences //////////////////// INICIO

                // Acessar o arquivo de preferencias compartilhadas
                val minhasPreferencias = getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE)

                // Salvar dados no arquivo de preferencias compartilhadas
                val editPrefs = minhasPreferencias.edit()
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)
                editPrefs.apply()

                //////////////////// Configurando o SharedPreferences //////////////////// FIM

                // Abrir MainActivity
                val mIntent = Intent(this, MainActivity::class.java)

                // Passar valores dentro da Intent
                mIntent.putExtra("INTENT_EMAIL", email)
                startActivity(mIntent)
                // Limpando a pilha de telas
                finishAffinity()



            }
        }
        ///////////////////////////// Botão Cadastrar ///////////////////////////// FIM
    }
}
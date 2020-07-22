package dev.douglas_cajueiro.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Escutar o botão entrar
        btnEntrar.setOnClickListener {

            //Capturar dados digitados
            val usuario = edtUsuario.text.toString().trim()
            val senha = edtLoginSenha.text.toString().trim()

            // Validar email e senha digitados
            if (usuario.isEmpty()) {
                edtUsuario.error = "Campo obrigatório"
                edtUsuario.requestFocus()
            } else if (senha.isEmpty()) {
                edtLoginSenha.error = "Campo obrigatório"
                edtLoginSenha.requestFocus()
            } else {

                // Acessar o arquivo de preferências compartilhadas
                val minhasPrefs = getSharedPreferences("cadastro-$usuario", Context.MODE_PRIVATE)

                //Obtendo dados no arquivo de preferências compartilhadas
                val usuarioPrefs = minhasPrefs.getString("EMAIL", "")
                val senhaPrefs = minhasPrefs.getString("SENHA", "")


                //Verificar e-mail e senha digitados
                if(usuario == usuarioPrefs && senha == senhaPrefs) {

                    // Criando um Toast
                    Toast.makeText(this, "Usuário Logado!", Toast.LENGTH_SHORT).show()

                    //Abrindo a MainActivity

                    val mIntent = Intent(this, MainActivity::class.java)
                    mIntent.putExtra("INTENT_EMAIL", usuario)
                    startActivity(mIntent)
                    finish()


                } else {

                    Toast.makeText(
                        this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show()
                }
            }

        }

        //Escutar botão Cadastrar
        btnCadastro.setOnClickListener {
            openCadastroActivity()
            
        }

    }


    private fun openCadastroActivity() {

        val intent = Intent(this, CadastroActivity::class.java)
        startActivity(intent)
    }



}
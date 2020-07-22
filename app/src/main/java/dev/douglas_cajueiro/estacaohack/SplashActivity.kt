package dev.douglas_cajueiro.estacaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    //Sobrescrita de método
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Aparecer por 3 segundos
        // ** Estudar ciclo de vida das Activities
        Handler().postDelayed({

            // Abrir outra activity
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)
            finish()

        }, 3000)
    }
}
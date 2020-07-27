package dev.douglas_cajueiro.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        //Habilitar JavaScript
        wbvSite.settings.javaScriptEnabled = true

        //Abrir a URL do site do Cel.lep
        wbvSite.loadUrl("http://br.cellep.com/estacaohack")

        // Definir o cliente padrão para abertura de URLs
        wbvSite.webViewClient = WebViewClient()


    }
}
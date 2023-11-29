package com.example.app_pedidosonline

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CarrinhoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)

        val btnPagamento = findViewById<Button>(R.id.btnPagamento)

        btnPagamento.setOnClickListener {
            // Lógica para proceder ao pagamento
            // Pode incluir a integração com um serviço de pagamento online, por exemplo
        }
    }
}
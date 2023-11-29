package com.example.app_pedidosonline

class PedidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido)

        val btnAdicionarAoCarrinho = findViewById<Button>(R.id.btnAdicionarAoCarrinho)

        btnAdicionarAoCarrinho.setOnClickListener {
            // Lógica para adicionar item ao carrinho
            // Pode ser feita utilizando uma lista ou banco de dados, dependendo das necessidades
        }
    }
}
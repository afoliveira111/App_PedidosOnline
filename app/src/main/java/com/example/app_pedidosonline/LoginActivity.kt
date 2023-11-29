package com.example.app_pedidosonline

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText: EditText = findViewById(R.id.editTextEmail)
        val senhaEditText: EditText = findViewById(R.id.editTextSenha)
        val loginButton: Button = findViewById(R.id.btnLogin)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val senha = senhaEditText.text.toString().trim()

            if (isValidInput(email, senha)) {
                // Autenticação com Firebase
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Login bem-sucedido, redirecionar para a tela de pedidos
                            startActivity(Intent(this, PedidoActivity::class.java))
                            finish()
                        } else {
                            // Tratar falha na autenticação
                            Toast.makeText(this, "Falha na autenticação. Verifique suas credenciais.", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                // Informar ao usuário que os campos são inválidos
                Toast.makeText(this, "Preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidInput(email: String, senha: String): Boolean {
        return email.isNotBlank() && senha.isNotBlank()
    }
}


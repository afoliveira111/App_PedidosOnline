package com.example.app_pedidosonline

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

            val emailEditText: EditText = findViewById(R.id.emailEditText)
            val passwordEditText: EditText = findViewById(R.id.passwordEditText)
            val loginButton: Button = findViewById(R.id.loginButton)

            loginButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (isValidInput(email, password)) {
                    // Autenticação com Firebase
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Login bem-sucedido, redirecionar para a tela de pedidos
                                startActivity(Intent(this, OrderActivity::class.java))
                                finish()
                            } else {
                                // Tratar falha na autenticação
                                Toast.makeText(this, "Autenticação falhou.", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    // Informar ao usuário que os campos são inválidos
                    Toast.makeText(this, "Preencha todos os campos corretamente.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun isValidInput(email: String, password: String): Boolean {
            return email.isNotEmpty() && password.isNotEmpty()
        }
    }
}
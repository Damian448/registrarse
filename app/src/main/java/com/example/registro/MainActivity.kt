package com.example.registro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth : FirebaseAuth
   private lateinit var authStateListener: FirebaseAuth.AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editaceptar : Button = findViewById(R.id.editaceptar)
        val txteditemail : TextView = findViewById(R.id.editemail)
        val txteditcontraseña : TextView = findViewById(R.id.editcontraseña)
        val bdtcrear_cuenta: TextView = findViewById(R.id.bdtcrear_cuenta)
        firebaseAuth= Firebase.auth
        editaceptar.setOnClickListener()
            {
                signIn(txteditemail.text.toString(),txteditcontraseña.text.toString())
            }
            bdtcrear_cuenta.setOnClickListener()
            {
                val i = android.content.Intent(this, CrearCuentaActivity::class.java)
                startActivity(i)
        }

    }
    private fun signIn(email: String, password: String)
    {
firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this)
{task ->
if (task.isSuccessful){
    val user = firebaseAuth.currentUser
    Toast.makeText(baseContext, "Autenticación Exitosa", Toast.LENGTH_SHORT).show()
    //aqui vamos ala segunda actividad
    val i = Intent( this, MainActivity2::class.java)
    startActivity(i)
}
    else
    {
        Toast.makeText(baseContext,"Error de Email y/o Contraseña", Toast.LENGTH_SHORT).show()
    }
}
    }
}
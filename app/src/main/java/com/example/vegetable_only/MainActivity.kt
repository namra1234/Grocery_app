package com.example.vegetable_only

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var button : Button
    lateinit var button_login : Button
    lateinit var emailVal: TextInputEditText
    lateinit var passwordval: TextInputEditText
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //        auth = Firebase.auth
        auth = FirebaseAuth.getInstance()
        var user = FirebaseAuth.getInstance().currentUser

        button = findViewById(R.id.button_register)
        button.setOnClickListener(this)

        button_login = findViewById(R.id.login)
        button_login.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_register->{
                val intent = Intent(this, Register::class.java).apply {}
                startActivity(intent)
                finish()
            }
            R.id.login->{
                login()
            }
        }
    }


    private fun login () {

        emailVal = findViewById(R.id.login_email) as TextInputEditText
        passwordval = findViewById(R.id.login_password) as TextInputEditText


        var email = emailVal.text.toString()
        var password = passwordval.text.toString()





        if (!email.isEmpty() && !password.isEmpty()) {
            this.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener ( this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
//                    startActivity(Intent(this, Timeline::class.java))
                    Toast.makeText(this, "Successfully Logged in :)", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error Logging in :(", Toast.LENGTH_SHORT).show()
                }
            })

        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }

}
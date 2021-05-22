package com.example.vegetable_only

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class Register : AppCompatActivity() , View.OnClickListener {
    lateinit var button : Button
    lateinit var name: TextInputEditText
    lateinit var email: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var nameval: TextInputEditText
    private lateinit var auth: FirebaseAuth
    lateinit var mDatabase : DatabaseReference




    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        auth = FirebaseAuth.getInstance()
        var user = FirebaseAuth.getInstance().currentUser


        setContentView(R.layout.activity_register)
        mDatabase = FirebaseDatabase.getInstance().getReference("Names")
        button = findViewById(R.id.button_login)
        button.setOnClickListener(this)
        button = findViewById(R.id.registerUser)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_login->{
                val intent = Intent(this, MainActivity::class.java).apply {}
                startActivity(intent)
                finish()
            }
            R.id.registerUser->{
                register();
            }
        }
    }
            fun register()
            {
                val nameval = findViewById(R.id.name) as TextInputEditText
                val emailVal = findViewById(R.id.email) as TextInputEditText
                val passwordval = findViewById(R.id.password) as TextInputEditText


                var email = emailVal.text.toString()
                var password = passwordval.text.toString()
                var name = nameval.text.toString()

                if (!email.isEmpty() && !password.isEmpty() && !name.isEmpty()) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this,
                        OnCompleteListener<AuthResult?> { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information

                                val user: FirebaseUser? = auth.getCurrentUser()
                                Toast.makeText(this, "Successfully registered. Please login now", Toast.LENGTH_LONG).show()

                                val intent = Intent(this, MainActivity::class.java).apply {}
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this, "Error in registration, try again later ", Toast.LENGTH_LONG).show()
                            }

                            // ...
                        })
            }else {
        Toast.makeText(this,"Please fill up the Credentials :|", Toast.LENGTH_LONG).show()
    }
            }

}
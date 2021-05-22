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
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class MainActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var button : Button
    lateinit var button_login : Button
    lateinit var emailVal: TextInputEditText
    lateinit var passwordval: TextInputEditText
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        //        auth = Firebase.auth
        auth = FirebaseAuth.getInstance()
        var user = FirebaseAuth.getInstance().currentUser

        button = findViewById(R.id.button_register)
        button.setOnClickListener(this)

        button_login = findViewById(R.id.login)
        button_login.setOnClickListener(this)

        button = findViewById(R.id.btGoogle)
        button.setOnClickListener(this)



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
            R.id.btGoogle->{
                signInwithGoogle()
            }
        }
    }
    // [START signin]
    private fun signInwithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, 9001)
    }
    // [END onactivityresult]

    // [START onactivityresult]
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);

            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!

                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                print(e)
            }

    }



    // [START auth_with_google]
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Successfully Logged in ", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, mainDashboard::class.java).apply {}
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Error Logging in ", Toast.LENGTH_SHORT).show()
                }
            }
    }
    // [END auth_with_google]





    private fun login () {

        emailVal = findViewById(R.id.login_email) as TextInputEditText
        passwordval = findViewById(R.id.login_password) as TextInputEditText


        var email = emailVal.text.toString()
        var password = passwordval.text.toString()





        if (!email.isEmpty() && !password.isEmpty()) {
            this.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener ( this, OnCompleteListener<AuthResult> { task ->
                if (task.isSuccessful) {
//                    startActivity(Intent(this, Timeline::class.java))
                    Toast.makeText(this, "Successfully Logged in ", Toast.LENGTH_LONG).show()

                    val intent = Intent(this, mainDashboard::class.java).apply {}
                    startActivity(intent)
                    finish()

                } else {
                    Toast.makeText(this, "Error Logging in ", Toast.LENGTH_SHORT).show()
                }
            })

        }else {
            Toast.makeText(this, "Please fill up the Credentials :|", Toast.LENGTH_SHORT).show()
        }
    }

}
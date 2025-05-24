package vcmsa.ci.flashcardsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        //Get score and total from intent
        val score = intent.getIntExtra("score", 0)
        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        val txtTotal:TextView = findViewById(R.id.txtTotal)
        val btnRestart:Button = findViewById(R.id.btnRestart)
        val btnExit : Button = findViewById(R.id.btnExit)

        //set total score
        txtTotal.text = "Your total score: $score out of 5"

        // Add feedback based on total score
        val message = if (score >= 3) "Great job!" else "Keep practising"
        txtTotal.append("\n$message")

        //Restart Quiz
        btnRestart.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Exit app
        btnExit.setOnClickListener {
            finishAffinity() // close the app
        }








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
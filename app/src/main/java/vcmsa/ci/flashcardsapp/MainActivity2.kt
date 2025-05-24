package vcmsa.ci.flashcardsapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView

private val questions = arrayOf(
    //History related questions
    "Brenda Fassie is considered the Queen of African Pop and known for the hit song Umqombothi",
    "Miriam Makeba, also known as Mama Africa,was a South African artist and anti-apartheid activist.",
    "Bubblegum music is from the 1980s.",
    "Gqom is the post-apartheid music genre that combines house music with local sounds.",
    "Ladysmith Black Mambazo,formed by Joseph Shabalala,is a famous South African male choral group."
)

private val answers = booleanArrayOf(
  false, // it was Yvonne Chaka Chaka who is known as the Queen of African Pop,while Brenda Fassie was the "Madonna of the Townships"= True
  true,
    true,
    false, // Amapiano is globally popular post-apartheid genre,Gqom is a different genre with a darker,more electric sound = True
  true
)
private var questionIndex = 0
private var score = 0

class MainActivi
 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val questionText = findViewById<TextView>(R.id.txtQuestion)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val txtResults = findViewById<TextView>(R.id.txtResults)

        questionText.text = questions[questionIndex]

        fun loadNextQuestion() {
            if (questionIndex < questions.size - 1) {
                questionIndex++
                questionText.text = questions[questionIndex]
            }else {
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                intent.putExtra("totalQuestions", questions.size)
                startActivity(intent)
                finish()

            }

            btnTrue.setOnClickListener {
                if (answers[questionIndex]) {
                    score++
                    Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this,"Incorrect",Toast.LENGTH_SHORT).show()
                }
                loadNextQuestion()
        }

        btnFalse.setOnClickListener {
            check(false)
        }

        btnNext.setOnClickListener {
            questionIndex++
            if (questionIndex < questions.size) {

                loadNextQuestion()
            }else {
                //
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                intent.putExtra("total", questions.size)
                startActivity(intent)
                finish()

            }


            }

        }
    }




        }








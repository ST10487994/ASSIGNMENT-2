package vcmsa.ci.flashcardsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {

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
private var currentIndex= 0
private var score = 0

// Tracking current question index and score
private lateinit var questionText: TextView
private lateinit var txtResult: TextView
private lateinit var nextButton: Button
private lateinit var trueButton: Button
private lateinit var falseButton: Button




    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)


        val questionText = findViewById<TextView>(R.id.txtQuestion)
        val trueButton = findViewById<Button>(R.id.btnTrue)
        val falseButton = findViewById<Button>(R.id.btnFalse)
        val nextButton = findViewById<Button>(R.id.btnNext)
        val txtResults = findViewById<TextView>(R.id.txtResults)

        loadQuestion()

        // Handle True button click
        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        // Handle False button click
        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        // Handle Next button click
        nextButton.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()
            } else {

                // End of quiz,go to score screen
                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("score", score)
                intent.putExtra("questions", questions)
                intent.putExtra("answers", answers)
                startActivity(intent)
                finish()


            }
        }


        // Load current question
        fun loadQuestion() {
            questionText.text = questions[currentIndex]
            txtResults.text = ""
            trueButton.isEnabled = true
            falseButton.isEnabled = true


        }
    }

    private fun loadQuestion() {
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer) {
            txtResult.text = "Correct"
            score++
        } else {
            txtResult.text = "Incorrect"

        }

        // Disable buttons after answering
        trueButton.isEnabled = false
        falseButton.isEnabled = false
    }


        }














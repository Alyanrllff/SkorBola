package lat.pam.skorbola

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.gamescore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mengamati perubahan skor tim A dan memperbarui UI
        gameViewModel.scoreTeamA.observe(this, Observer { score ->
            binding.textViewScoreTeamA.text = score.toString()
        })

        // Mengamati perubahan skor tim B dan memperbarui UI
        gameViewModel.scoreTeamB.observe(this, Observer { score ->
            binding.textViewScoreTeamB.text = score.toString()
        })

        // Tombol untuk menambah skor tim A
        binding.buttonAddTeamA.setOnClickListener {
            gameViewModel.addScoreTeamA(1) // Tambah 1 poin ke tim A
        }

        // Tombol untuk menambah skor tim B
        binding.buttonAddTeamB.setOnClickListener {
            gameViewModel.addScoreTeamB(1) // Tambah 1 poin ke tim B
        }

        // Tombol untuk mereset skor
        binding.buttonReset.setOnClickListener {
            gameViewModel.resetScores()
        }
    }
}
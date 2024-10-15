package lat.pam.skorbola

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    // LiveData untuk skor tim A dan tim B
    private val _scoreTeamA = MutableLiveData<Int>()
    val scoreTeamA: LiveData<Int> get() = _scoreTeamA

    private val _scoreTeamB = MutableLiveData<Int>()
    val scoreTeamB: LiveData<Int> get() = _scoreTeamB

    // Inisialisasi nilai awal skor
    init {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }

    // Fungsi untuk menambah skor tim A
    fun addScoreTeamA(points: Int) {
        _scoreTeamA.value = (_scoreTeamA.value ?: 0) + points
    }

    // Fungsi untuk menambah skor tim B
    fun addScoreTeamB(points: Int) {
        _scoreTeamB.value = (_scoreTeamB.value ?: 0) + points
    }

    // Fungsi untuk reset skor
    fun resetScores() {
        _scoreTeamA.value = 0
        _scoreTeamB.value = 0
    }
}

package my.company.poedit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import my.company.poedit.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var isGameModeActive = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Кнопка игрового режима
        binding.gameModeToggle.setOnClickListener {
            isGameModeActive = !isGameModeActive
            binding.gameModeToggle.text = if (isGameModeActive) {
                "🎮 Игровой режим: ВКЛ"
            } else {
                "🎮 Игровой режим: ВЫКЛ"
            }
            showToast(if (isGameModeActive) "Режим активирован" else "Режим отключён")
        }

        // Заглушки для кнопок настроек
        binding.btnSensitivity.setOnClickListener { showToast("Настройка чувствительности") }
        binding.btnDpi.setOnClickListener { showToast("Настройка DPI") }
        binding.btnMapping.setOnClickListener { showToast("Переназначение клавиш") }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Предотвращаем утечку памяти
    }
}
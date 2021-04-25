package school.cactus.succulentshop.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

private lateinit var binding: ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
package school.cactus.succulentshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivitySignUpBinding
import school.cactus.succulentshop.ui.validators.AdvancedPasswordValidator
import school.cactus.succulentshop.ui.validators.EmailValidator
import school.cactus.succulentshop.ui.validators.UserNameValidator
import school.cactus.succulentshop.ui.validators.validate

private lateinit var binding: ActivitySignUpBinding
class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.sign_up)

        binding.signUpButton.setOnClickListener {
            binding.emailInputLayout.validate(EmailValidator())
            binding.usernameInputLayout.validate(UserNameValidator())
            binding.passwordInputLayout.validate(AdvancedPasswordValidator())
        }
        binding.haveAnAccountButton.setOnClickListener { onBackPressed() }
    }
}
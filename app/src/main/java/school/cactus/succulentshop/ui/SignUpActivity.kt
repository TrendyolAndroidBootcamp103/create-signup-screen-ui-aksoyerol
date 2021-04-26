package school.cactus.succulentshop.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivitySignUpBinding
import school.cactus.succulentshop.ui.validators.AdvancedPasswordValidator
import school.cactus.succulentshop.ui.validators.EmailValidator
import school.cactus.succulentshop.ui.validators.UserNameValidator
import school.cactus.succulentshop.ui.validators.validate

private lateinit var binding: ActivitySignUpBinding
private val emailValidator = EmailValidator()
private val userNameValidator = UserNameValidator()
private val advancedPasswordValidator = AdvancedPasswordValidator()

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.sign_up)

        binding.signUpButton.setOnClickListener {
            binding.emailInputLayout.validate(emailValidator)
            binding.usernameInputLayout.validate(userNameValidator)
            binding.passwordInputLayout.validate(advancedPasswordValidator)
        }

        binding.haveAnAccountButton.setOnClickListener {
            navigateToLoginScreen()
        }
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

}
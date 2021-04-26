package school.cactus.succulentshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import school.cactus.succulentshop.databinding.ActivitySignUpBinding
import school.cactus.succulentshop.ui.validators.EmailValidator
import school.cactus.succulentshop.ui.validators.UserNameValidator
import school.cactus.succulentshop.ui.validators.validate

private lateinit var binding: ActivitySignUpBinding
private val emailValidator = EmailValidator()
private val userNameValidator = UserNameValidator()

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signUpButton.setOnClickListener {
            binding.emailInputLayout.validate(emailValidator)
            binding.usernameInputLayout.validate(userNameValidator)
        }
    }
}
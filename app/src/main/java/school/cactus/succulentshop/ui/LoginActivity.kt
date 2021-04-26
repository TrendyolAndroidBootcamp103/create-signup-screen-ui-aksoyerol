package school.cactus.succulentshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivityLoginBinding
import school.cactus.succulentshop.ui.validators.IdentifierValidator
import school.cactus.succulentshop.ui.validators.PasswordValidator
import school.cactus.succulentshop.ui.validators.validate

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val identifierValidator = IdentifierValidator()
    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.log_in)

        binding.apply {
            logInButton.setOnClickListener {
                passwordInputLayout.validate(passwordValidator)
                identifierInputLayout.validate(identifierValidator)
            }
        }
    }

//    private fun TextInputLayout.validate() {
//        val errorMessage = validator().validate(editText!!.text.toString())
//        error = errorMessage?.resolveAsString()
//        isErrorEnabled = errorMessage != null
//    }
//
//    private fun Int.resolveAsString() = getString(this)
//
//    private fun TextInputLayout.validator() = when (this) {
//        binding.identifierInputLayout -> identifierValidator
//        binding.passwordInputLayout -> passwordValidator
//        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
//    }
}

package school.cactus.succulentshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivityLoginBinding
import school.cactus.succulentshop.util.helpers.validate
import school.cactus.succulentshop.util.validators.IdentifierValidator
import school.cactus.succulentshop.util.validators.PasswordValidator

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
            createAccountButton.setOnClickListener { onBackPressed() }
        }
    }
}

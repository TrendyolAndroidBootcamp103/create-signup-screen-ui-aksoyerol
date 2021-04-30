package school.cactus.succulentshop.util.validators


import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

import school.cactus.succulentshop.R

class AdvancedPasswordValidatorTest {

    private lateinit var validator: Validator

    @Before
    fun setup() {
        validator = AdvancedPasswordValidator()
    }

    @Test
    fun validateWithEmpty() {
        val password = ""
        val response = validator.validate(password)
        assertThat(response).isEqualTo(R.string.password_is_required)
    }

    @Test
    fun validateMinimumCharacterSize() {
        val password = "pass" //size -> 4
        val response = validator.validate(password)
        assertThat(response).isEqualTo(R.string.password_is_too_short)
    }

    @Test
    fun validateMaximumCharacterSize() {
        val password = "PassPassPassPassPassPassPassPassPassPass" //size -> 40
        val response = validator.validate(password)
        assertThat(response).isEqualTo(R.string.password_is_too_long)
    }

    @Test
    fun validateWithNotDigitCharacter() {
        val password = "Password?"
        val response = validator.validate(password)
        assertThat(response).isEqualTo(R.string.password_must_contains_rules)
    }

    @Test
    fun validateWithNotUpperCaseCharacters() {
        val password = "password1?@"
        val response = validator.validate(password)
        assertThat(response).isEqualTo(R.string.password_must_contains_rules)
    }

    @Test
    fun validateWithNotLowerCaseCharacters() {
        val password = "PASSWORD1?@"
        val response = validator.validate(password)
        assertThat(response).isEqualTo(R.string.password_must_contains_rules)
    }

    @Test
    fun validateWithIsLetterOrDigit() {
        val password = "Password12"
        val response = validator.validate(password)
        assertThat(response).isEqualTo(R.string.password_must_contains_rules)
    }

    @Test
    fun validateWithTruePassword() {
        val password = "Password12@"
        val response = validator.validate(password)
        assertThat(response).isEqualTo(null)
    }
}
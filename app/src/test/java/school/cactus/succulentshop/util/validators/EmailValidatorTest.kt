package school.cactus.succulentshop.util.validators

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import school.cactus.succulentshop.R

class EmailValidatorTest {

    private lateinit var validator: Validator

    @Before
    fun setUp() {
        validator = EmailValidator()
    }

    @Test
    fun `validate test shorter than 5 characters`() {
        val mail = "e@g."
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test longer than 50 characters`() {
        val mail = "johndoejohndoejohndoejohndoejohndoejohndoe@lastname.com" //-> 55 chars
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test without @ character`() {
        val mail = "erolaksoygmail.com"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test without dot character`() {
        val mail = "erolaksoy@gmail"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test complex characters`() {
        val mail = "#@%^%#\$@#\$@#.com"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test with spacing mail`() {
        val mail = "Joe Smith <email@example.com>"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test multiple @ uses`() {
        val mail = "email@example@example.com"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test fail end character`() {
        val mail = "email@example.com (Joe Smith)"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test many dot character`() {
        val mail = "Abc..123@example.com"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test with strange characters`() {
        val mail = "”(),:;<>[\\]@example.com"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate test with multiple spacing`() {
        val mail = "erol aksoy 98 @ gmail . com"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(R.string.email_is_invalid)
    }

    @Test
    fun `validate true format mail`() {
        val mail = "firstname.lastname@example.com"
        val response = validator.validate(mail)
        assertThat(response).isEqualTo(null)
    }
}
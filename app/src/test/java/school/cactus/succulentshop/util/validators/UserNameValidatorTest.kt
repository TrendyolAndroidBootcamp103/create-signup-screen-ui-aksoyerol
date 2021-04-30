package school.cactus.succulentshop.util.validators

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import school.cactus.succulentshop.R

class UserNameValidatorTest {


    private lateinit var validator: Validator

    @Before
    fun setUp() {
        validator = UserNameValidator()
    }

    @Test
    fun validateWithRegexPattern() {
        //Empty Control
        assertThat(validator.validate("")).isEqualTo(R.string.username_is_required)
        //Is Shorter than 2 Char Control
        assertThat(validator.validate("ea")).isEqualTo(R.string.username_is_too_short)
        ////Is Shorter Longer than 20 Char Control
        assertThat(validator.validate("eaesaeaeaeaeaeaeaeaea")).isEqualTo(R.string.username_is_too_long)

        //Regex Pattern Control
        assertThat(validator.validate("   first_last")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("first last ")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("first last _")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("first_last ")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("first-last")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("first?last")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("first@last@")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("first@last_")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("first_last-")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("-first_last")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate("  ")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate(" . ")).isEqualTo(R.string.username_can_only_include_az_09_characters)
        assertThat(validator.validate(" _ ")).isEqualTo(R.string.username_can_only_include_az_09_characters)

        //True Format Control
        assertThat(validator.validate("firstname")).isEqualTo(null)
        assertThat(validator.validate("first_name")).isEqualTo(null)
        assertThat(validator.validate("first_name_")).isEqualTo(null)
    }
}
package school.cactus.succulentshop.ui.validators

import school.cactus.succulentshop.R
import java.util.regex.Pattern

class UserNameValidator : Validator {
    companion object {
        const val USERNAME_REGEX = "^[A-Za-z0-9_]+\$"
    }

    override fun validate(field: String): Int? = when {
        field.isEmpty() -> R.string.username_is_required
        !Pattern.compile(USERNAME_REGEX).matcher(field)
            .matches() -> R.string.username_can_only_include_az_09_characters
        field.length <= 2 -> R.string.username_is_too_short
        field.length >= 20 -> R.string.username_is_too_long
        else -> null
    }
}
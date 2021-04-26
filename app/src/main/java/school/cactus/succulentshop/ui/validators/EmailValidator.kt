package school.cactus.succulentshop.ui.validators

import school.cactus.succulentshop.R
import java.util.regex.Pattern

class EmailValidator : Validator {
    companion object {
        const val EMAIL_REGEX =
            "(?:[a-z0-9!#\$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#\$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    }

    override fun validate(field: String): Int? = when {
        field.isEmpty() -> R.string.email_is_required
        field.length <= 5 -> R.string.email_is_invalid
        !Pattern.compile(EMAIL_REGEX).matcher(field).matches() -> R.string.email_is_invalid
        field.length >= 50 -> R.string.email_is_invalid
        else -> null
    }
}
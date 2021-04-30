package school.cactus.succulentshop.util.validators

import school.cactus.succulentshop.R

class AdvancedPasswordValidator : Validator {
    override fun validate(field: String): Int? {
        return when {
            field.isEmpty() -> R.string.password_is_required
            field.length <= 7 -> R.string.password_is_too_short
            field.length >= 40 -> R.string.password_is_too_long
            !field.any { it.isDigit() } -> R.string.password_must_contains_rules
            !field.any { it.isLowerCase() } -> R.string.password_must_contains_rules
            !field.any { it.isUpperCase() } -> R.string.password_must_contains_rules
            !field.any { !it.isLetterOrDigit() } -> R.string.password_must_contains_rules
            else -> null
        }
    }
}
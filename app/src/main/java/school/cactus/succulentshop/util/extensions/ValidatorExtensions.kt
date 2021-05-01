package school.cactus.succulentshop.util.extensions

import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.util.validators.Validator

fun TextInputLayout.validate(validator: Validator) {
    val errorMessage = validator.validate(editText!!.text.toString())
    error = errorMessage?.let { this.context.getString(it) }
    isErrorEnabled = errorMessage != null
}
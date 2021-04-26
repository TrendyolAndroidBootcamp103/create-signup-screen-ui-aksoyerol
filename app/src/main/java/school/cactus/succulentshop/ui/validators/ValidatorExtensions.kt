package school.cactus.succulentshop.ui.validators

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.validate(validator: Validator) {
    val errorMessage = validator.validate(editText!!.text.toString())
    error = errorMessage?.let { this.context.getString(it) }
    isErrorEnabled = errorMessage != null
}
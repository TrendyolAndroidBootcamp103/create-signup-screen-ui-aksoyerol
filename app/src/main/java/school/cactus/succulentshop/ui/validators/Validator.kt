package school.cactus.succulentshop.ui.validators

interface Validator {
    fun validate(field: String): Int?
}
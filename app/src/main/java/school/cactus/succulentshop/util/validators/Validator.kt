package school.cactus.succulentshop.util.validators

interface Validator {
    fun validate(field: String): Int?
}
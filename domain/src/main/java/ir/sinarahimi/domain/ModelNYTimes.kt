package ir.sinarahimi.domain

sealed class ModelNYTimes {

    data class Book(
        val publisher: String,
        val description: String,
        val author: String,
        val title: String,
        val bookImage: String,
        val buyLinks: List<Buy>
    ) : ModelNYTimes()

    data class Buy(
        val name: String,
        val url: String
    ) : ModelNYTimes()
}
package ir.sinarahimi.persistence.mapper

import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.persistence.database.Table
import ir.sinarahimi.persistence.database.dao.BookAndBuyLinks

/**
 * Created by Sina Rahimi on 2/17/2021.
 */

fun BookAndBuyLinks.mapToModel() = ModelNYTimes.Book(
    publisher = book.publisher,
    description = book.description,
    author = book.author,
    title = book.title,
    bookImage = book.bookImage,
    buyLinks = buyLinks.map { it.mapToModel() }
)

fun Table.BuyLink.mapToModel() = ModelNYTimes.BuyLink(
    name = name,
    url = url
)

fun ModelNYTimes.Book.mapToTable() = Table.Book(
    title = title,
    publisher = publisher,
    description = description,
    author = author,
    bookImage = bookImage
)

fun ModelNYTimes.BuyLink.mapToTable(bookTitle: String) = Table.BuyLink(
    bookTitle = bookTitle,
    name = name,
    url = url
)
package ir.sinarahimi.network.mapper

import ir.sinarahimi.domain.ModelNYTimes
import ir.sinarahimi.network.api.Dto

/**
 * Created by Sina Rahimi on 2/14/2021.
 */

fun Dto.Book.dtoToModel() = ModelNYTimes.Book(
    publisher = publisher,
    description = description,
    author = author,
    title = title,
    bookImage = bookImage,
    buyLinks = buyLinks.map { it.dtoToModel() }
)

fun Dto.Buy.dtoToModel() = ModelNYTimes.Buy(
    name = name,
    url = url
)
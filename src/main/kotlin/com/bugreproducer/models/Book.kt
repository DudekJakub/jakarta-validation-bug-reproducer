package com.bugreproducer.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.Valid
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class Book(

    @JsonProperty("title")
    @NotBlank(message = "Title may not be blank")
    val title: String,

    @JsonProperty("author")
    @NotBlank(message = "Author may not be blank")
    val author: String,

    @JsonProperty("pages")
    @Min(message = "Author has been very lazy", value = 1)
    val pages: Double,

    @Valid
    @NotNull
    @Size(min = 2, max = 4)
    @JsonProperty("publishers")
    val publishers: List<Publisher>
)
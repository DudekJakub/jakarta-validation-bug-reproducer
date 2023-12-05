package com.bugreproducer.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.Size

data class Publisher(

    @JsonProperty("name")
    @Size(min = 5, max = 20)
    val name: String
)
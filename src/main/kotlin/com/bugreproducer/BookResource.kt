package com.bugreproducer

import com.bugreproducer.models.Book
import jakarta.inject.Inject
import jakarta.validation.ConstraintViolation
import jakarta.validation.Valid
import jakarta.validation.Validator
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import java.util.stream.Collectors

@Path("/books")
class BookResource {

    @Inject
    lateinit var validator: Validator

    @Path("/manual-validation")
    @POST
    fun tryMeManualValidation(book: Book): Result {
        val violations: Set<ConstraintViolation<Book>> = validator.validate(book)
        println(book)
        return if (violations.isEmpty()) {
            Result("Book is valid! It was validated by manual validation.")
        } else {
            Result(violations)
        }
    }

    @Path("/end-point-method-validation")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun tryMeEndPointMethodValidation(book: @Valid Book): Result {
        println(book)
        return Result("Book is valid! It was validated by end point method validation.")
    }


    inner class Result private constructor(message: String, success: Boolean) {

        private val message: String = message
        private val success: Boolean = success

        constructor(message: String) : this(message, true)

        constructor(violations: Set<ConstraintViolation<*>>) : this(
            violations.stream()
                .map { cv -> cv.message }
                .collect(Collectors.joining(", ")),
            false
        )

        fun getMessage(): String {
            return message
        }

        fun isSuccess(): Boolean {
            return success
        }
    }
}
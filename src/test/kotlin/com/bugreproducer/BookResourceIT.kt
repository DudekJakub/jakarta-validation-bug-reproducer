package com.bugreproducer

import com.bugreproducer.models.Book
import com.bugreproducer.models.Publisher
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.jupiter.api.Test

@QuarkusTest
class BookResourceIT {

    @Test
    fun testValidBookSuccess() {
        val validBook = Book("Clean Code", "Robert C. Martin", 69420.0, listOf(Publisher("testPublisher1"), Publisher("testPublisher2")))

        given()
            .contentType(ContentType.JSON)
            .body(validBook)
            .post("/books/manual-validation")
            .then()
            .statusCode(200)

        given()
            .contentType(ContentType.JSON)
            .body(validBook)
            .post("/books/end-point-method-validation")
            .then()
            .statusCode(200)
    }

    @Test
    fun testInvalidBookFailure() {
        val invalidBook = Book("", "", 0.0, listOf(Publisher("testPublisher1")))

        given()
            .contentType(ContentType.JSON)
            .body(invalidBook)
            .post("/books/manual-validation")
            .then()
            .statusCode(400)

        given()
            .contentType(ContentType.JSON)
            .body(invalidBook)
            .post("/books/end-point-method-validation")
            .then()
            .statusCode(400)
    }
}
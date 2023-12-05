package com.bugreproducer.exceptions

import jakarta.inject.Singleton
import jakarta.validation.ValidationException
import jakarta.ws.rs.container.ContainerRequestContext
import jakarta.ws.rs.core.Response
import org.jboss.resteasy.reactive.server.ServerExceptionMapper
import java.lang.Error

@Singleton
class ExceptionsMapper {

        @ServerExceptionMapper
        fun mapException(exception: Throwable, requestContext: ContainerRequestContext): Response {
            println(exception.cause!!.message)
            return Response
                .status(400)
                .entity(Error())
                .build()
        }
}
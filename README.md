# jakarta-validation-bug-reproducer

Reproductin of jakarta validation bug. 

Following page: https://quarkus.io/guides/validation

Expected behaviour:
Controller 'BookResource' should not accept invalid dto 'Book' which all fields ought to be validated properly.

Actual behaviour:
Given controller despite exptected validation (which seems to be working only for @NotNull annotation) accepts invalid dto 'Book'. Annotations such as @Valid, @NotBlank, @Size, @Min are being ignored.

Settings:
- Quarkus 3.6.0
- Gradle 8.4
- implementation("jakarta.validation:jakarta.validation-api:3.0.2")
- implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
- implementation("io.quarkus:quarkus-hibernate-validator")




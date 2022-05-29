package com.animalia.crudanimalia.model.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNull;
import static com.animalia.crudanimalia.utils.validator.ValidadorUtils.cantBeNullOrEmpty;

public class ValidatorUtilsTest {

    @ParameterizedTest
    @NullSource
    void should_throw_exception_when_field_is_null(String field) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cantBeNull(field));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void should_throw_exception_when_field_is_null_and_empty(String field) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> cantBeNullOrEmpty(field));
    }
}

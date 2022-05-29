package com.animalia.crudanimalia.utils.validator;

public class ValidadorUtils {

    public static void cantBeNull(Object object) {
        cantBeNull(object, "the object should not be null");
    }

    public static void cantBeNull(Object object, String errorMessage) {
        if (object == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void cantBeNullOrEmpty(String field) {
        cantBeNullOrEmpty(field, "The field name should not be null or empty!");
    }

    public static void cantBeNullOrEmpty(String field, String errorMessage) {
        if (field == null || field.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}

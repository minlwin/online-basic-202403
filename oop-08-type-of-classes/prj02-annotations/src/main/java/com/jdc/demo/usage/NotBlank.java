package com.jdc.demo.usage;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(value = FIELD)
public @interface NotBlank {

	String value() default "Error for blank string.";
}

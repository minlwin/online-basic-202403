package com.jdc.demo.usage;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface NotNullAndNotBlank {

	NotBlank notBlank();
	NotNull notNull();
}

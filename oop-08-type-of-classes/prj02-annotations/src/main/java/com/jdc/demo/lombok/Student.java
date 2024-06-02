package com.jdc.demo.lombok;

import com.jdc.demo.usage.NotBlank;
import com.jdc.demo.usage.NotNull;
import com.jdc.demo.usage.NotNullAndNotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private int id;
	@NotNullAndNotBlank(
		notNull = @NotNull,
		notBlank = @NotBlank
	)
	private String name;
	private String phone;
	private String email;
}

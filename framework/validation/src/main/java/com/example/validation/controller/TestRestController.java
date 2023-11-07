package com.example.validation.controller;

import jakarta.validation.constraints.NotBlank;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TestRestController {

	@PostMapping(value = "hello", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String hello(@Validated @RequestBody Dto dto) {
		return "Hello " + dto.getName();
	}

	@PostMapping(value = "inherited-hello", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String inheritedHello(@Validated @RequestBody InheritedDto dto) {
		return "Inherited Hello " + dto.getName();
	}

	static class Dto {

		@NotBlank
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	static class InheritedDto extends Dto {
	}

}

/*
 * Copyright 2022-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.resource;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
class TestMethods {

	private String hello;

	private String test;

	private Integer number;

	@Resource
	public void setHello(String hello) {
		this.hello = hello;
	}

	@Resource
	public void setTest(String test) {
		this.test = test;
	}

	@Resource
	public void setNumber(Integer number) {
		this.number = number;
	}

	public String describe() {
		return "hello='%s',test='%s',number=%s".formatted(this.hello, this.test, this.number);
	}

}

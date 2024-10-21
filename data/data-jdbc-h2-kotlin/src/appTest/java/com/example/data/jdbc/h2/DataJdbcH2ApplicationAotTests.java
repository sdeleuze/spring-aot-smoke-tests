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

package com.example.data.jdbc.h2;

import java.time.Duration;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

import org.springframework.aot.smoketest.support.assertj.AssertableOutput;
import org.springframework.aot.smoketest.support.junit.ApplicationTest;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationTest
class DataJdbcH2ApplicationAotTests {

	@Test
	void insert(AssertableOutput output) {
		Awaitility.await().atMost(Duration.ofSeconds(10)).untilAsserted(() -> {
			assertThat(output).hasSingleLineContaining("insertAuthors(): author1 = Author(name='Josh Long')")
				.hasSingleLineContaining("insertAuthors(): author2 = Author(name='Martin Kleppmann')");
		});
	}

	@Test
	void listAllAuthors(AssertableOutput output) {
		Awaitility.await().atMost(Duration.ofSeconds(10)).untilAsserted(() -> {
			assertThat(output).hasSingleLineContaining("listAllAuthors(): author = Author(name='Josh Long')")
				.hasSingleLineContaining("Book(title='Cloud Native Java')")
				.hasSingleLineContaining("Book(title='Reactive Spring')")
				.hasSingleLineContaining("listAllAuthors(): author = Author(name='Martin Kleppmann')")
				.hasSingleLineContaining("Book(title='Designing Data Intensive Applications')");
		});
	}

	@Test
	void findById(AssertableOutput output) {
		Awaitility.await().atMost(Duration.ofSeconds(10)).untilAsserted(() -> {
			assertThat(output).hasSingleLineContaining("findById(): author1 = Author(name='Josh Long')")
				.hasSingleLineContaining("findById(): author2 = Author(name='Martin Kleppmann')");
		});
	}

	@Test
	void queryDerivedFromMethodName(AssertableOutput output) {
		Awaitility.await().atMost(Duration.ofSeconds(10)).untilAsserted(() -> {
			assertThat(output).hasSingleLineContaining("findByPartialName(): author1 = Author(name='Josh Long')")
				.hasSingleLineContaining("findByPartialName(): author2 = Author(name='Martin Kleppmann')");
		});
	}

	@Test
	void queryAnnotatedMethod(AssertableOutput output) {
		Awaitility.await().atMost(Duration.ofSeconds(10)).untilAsserted(() -> {
			assertThat(output).hasSingleLineContaining("queryFindByName(): author1 = Author(name='Josh Long')")
				.hasSingleLineContaining("queryFindByName(): author2 = Author(name='Martin Kleppmann')");
		});
	}

	@Test
	void deleteAll(AssertableOutput output) {
		Awaitility.await().atMost(Duration.ofSeconds(10)).untilAsserted(() -> {
			assertThat(output).hasSingleLineContaining("deleteAll(): count = 0");
		});
	}

}

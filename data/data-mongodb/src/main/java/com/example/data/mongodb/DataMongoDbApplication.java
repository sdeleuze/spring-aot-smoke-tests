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

package com.example.data.mongodb;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoManagedTypes;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableMongoAuditing(auditorAwareRef = "fixedAuditor")
@EnableTransactionManagement
public class DataMongoDbApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DataMongoDbApplication.class, args);
		Thread.currentThread().join(); // To be able to measure memory consumption
	}

	@Bean
	AuditorAware<String> fixedAuditor() {
		return () -> Optional.of("Douglas Adams");
	}

	@Bean
	public MongoCustomConversions mongoCustomConversions() {

		return new MongoCustomConversions(Arrays.asList(new StringToNameConverter(), new NameToStringConverter()));
	}

	@Bean
	public MongoManagedTypes managedTypes() {
		return MongoManagedTypes.from(Customer.class, Order.class);
	}

	@Bean
	public MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory mongoDatabaseFactory) {
		return new MongoTransactionManager(mongoDatabaseFactory);
	}

	@ReadingConverter
	public static class StringToNameConverter implements Converter<String, Name> {

		@Override
		public Name convert(String source) {

			String[] args = source.split(";");
			return new Name(args[0].trim(), args[1].trim());
		}

	}

	@WritingConverter
	public static class NameToStringConverter implements Converter<Name, String> {

		@Override
		public String convert(Name source) {
			return source.getFirstname() + "; " + source.getLastname();
		}

	}

}

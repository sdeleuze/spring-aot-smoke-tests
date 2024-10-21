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

package com.example.actuator.webflux;

import java.time.Duration;

import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class RegisterCustomTimer implements CommandLineRunner {

	private final MeterRegistry meterRegistry;

	RegisterCustomTimer(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}

	@Override
	public void run(String... args) {
		this.meterRegistry.timer("custom.timer").record(Duration.ofSeconds(5));
	}

}

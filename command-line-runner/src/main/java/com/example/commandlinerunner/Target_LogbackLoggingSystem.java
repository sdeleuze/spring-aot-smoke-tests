package com.example.commandlinerunner;

import java.net.URL;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.core.joran.spi.JoranException;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

import org.springframework.boot.logging.LoggingInitializationContext;

@TargetClass(className = "org.springframework.boot.logging.logback.LogbackLoggingSystem")
final class Target_LogbackLoggingSystem {

	@Substitute
	private void configureByResourceUrl(LoggingInitializationContext initializationContext, LoggerContext loggerContext,
			URL url) throws JoranException {
		new ContextInitializer(loggerContext).configureByResource(url);
	}

}

package com.example.commandlinerunner;

import java.net.URL;

import ch.qos.logback.core.joran.spi.JoranException;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "ch.qos.logback.classic.util.ContextInitializer")
final class Target_ContextInitializer {

	@Substitute
	public void configureByResource(URL url) throws JoranException {
	}

}

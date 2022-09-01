package com.example.commandlinerunner;

import java.net.URL;

import ch.qos.logback.classic.LoggerContext;
import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "ch.qos.logback.classic.selector.ContextJNDISelector")
final class Target_ContextJNDISelector {

	@Substitute
	private void configureLoggerContextByURL(LoggerContext context, URL url) {
	}

}

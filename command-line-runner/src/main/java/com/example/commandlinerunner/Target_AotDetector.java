package com.example.commandlinerunner;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "org.springframework.aot.AotDetector")
final class Target_AotDetector {

	@Substitute
	public static boolean useGeneratedArtifacts() {
		return true;
	}

}

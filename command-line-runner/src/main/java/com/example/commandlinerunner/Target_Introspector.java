package com.example.commandlinerunner;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "java.beans.Introspector")
final class Target_Introspector {

	@Substitute
	private static Class<?> findCustomizerClass(Class<?> type) {
		return null;
	}

}

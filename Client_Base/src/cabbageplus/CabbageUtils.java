package cabbageplus;

import cabbageplus.plugins.PluginHelper;
import cabbageplus.reflection.Reflector;

public class CabbageUtils {
	private static final Reflector reflector = new Reflector();

	public static Reflector getReflector() {
		return reflector;
	}

	public static Object getObjectMember(Object obj, String member) {
		return reflector.getObjectMember(obj, member);
	}

	public static String getObjectMemberString(Object obj, String member) {
		return (String) reflector.getObjectMember(obj, member);
	}

	public static int getObjectMemberInt(Object obj, String member) {
		return (int) reflector.getObjectMember(obj, member);
	}
}

package ocanalyzer.rules.fake;

import org.eclipse.jdt.core.dom.CompilationUnit;

public class FakeUnit {

	private static final String CLASS_HEAD = "class Foo {";
	private static final String CLASS_FOOT = "}";

	private static final String METHOD_HEAD = "void Foo() {";
	private static final String METHOD_FOOT = "}";

	private String code;

	public FakeUnit(String code) {
		this.code = code;
	}

	public CompilationUnit createPlain() {
		return CompilationUnitFactory.createFromCodeString(code);
	}

	public CompilationUnit createWithinClass() {
		StringBuffer buffer = new StringBuffer();
		this.helperWithinMethod(buffer, code);
		this.helperWithinClass(buffer, buffer.toString());

		String code = buffer.toString();
		return CompilationUnitFactory.createFromCodeString(code);
	}

	public CompilationUnit createWithinMethod() {
		StringBuffer buffer = new StringBuffer();
		this.helperWithinMethod(buffer, code);

		String code = buffer.toString();
		return CompilationUnitFactory.createFromCodeString(code);
	}

	private void helperWithinClass(StringBuffer buffer, String code) {
		buffer.append(CLASS_HEAD);
		buffer.append(code);
		buffer.append(CLASS_FOOT);
	}

	private void helperWithinMethod(StringBuffer buffer, String code) {
		buffer.append(METHOD_HEAD);
		buffer.append(code);
		buffer.append(METHOD_FOOT);
	}

}

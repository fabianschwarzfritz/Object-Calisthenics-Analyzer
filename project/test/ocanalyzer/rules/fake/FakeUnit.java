package ocanalyzer.rules.fake;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
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

	public CompilationUnit create() {
		return create(code);
	}

	public CompilationUnit createWithinClass() {
		StringBuffer buffer = new StringBuffer();
		this.helperWithinMethod(buffer, code);
		this.helperWithinClass(buffer, buffer.toString());
		return create(buffer.toString());
	}

	public CompilationUnit createWithinMethod() {
		StringBuffer buffer = new StringBuffer();
		this.helperWithinMethod(buffer, code);
		return create(buffer.toString());
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

	private static CompilationUnit create(String code) {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setSource(code.toCharArray());
		return (CompilationUnit) parser.createAST(null);
	}

}

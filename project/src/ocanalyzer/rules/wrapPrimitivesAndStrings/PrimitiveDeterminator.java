package ocanalyzer.rules.wrapPrimitivesAndStrings;

import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.StringLiteral;

public class PrimitiveDeterminator {

	public boolean isPrimitive(ITypeBinding resolveTypeBinding) {
		boolean primitive = resolveTypeBinding.isPrimitive();
		boolean string = resolveTypeBinding.getName().equals("String");
		// boolean literal = resolveTypeBinding instanceof StringLiteral;
		return primitive || string;// || literal;
	}
}

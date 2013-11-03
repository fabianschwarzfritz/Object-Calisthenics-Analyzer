package ocanalyzer.rules.wrapPrimitivesAndStrings;

import org.eclipse.jdt.core.dom.ITypeBinding;

public class PrimitiveDeterminator {

	public boolean isPrimitive(ITypeBinding resolveTypeBinding) {
		boolean primitive = resolveTypeBinding.isPrimitive()
				& !resolveTypeBinding.getName().equals("void");
		boolean string = resolveTypeBinding.getName().equals("String");
		// boolean literal = resolveTypeBinding instanceof StringLiteral;
		return primitive || string;// || literal;
	}
}

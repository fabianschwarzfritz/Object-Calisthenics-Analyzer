package ocanalyzer.rules.wrapPrimitivesAndStrings;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;

public class WrapPrimitivesVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	public WrapPrimitivesVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
	}

}
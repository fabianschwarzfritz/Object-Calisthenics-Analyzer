package ocanalyzer.rules.r5_shortnames;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.AnnotationTypeDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class ShortNamesVisitor extends ASTVisitor {

	private ValidationHandler handler;

	public ShortNamesVisitor(ValidationHandler validationHandler) {
		this.handler = validationHandler;
	}

	@Override
	public void endVisit(TypeDeclaration node) {
		
	}

	@Override
	public void endVisit(VariableDeclarationFragment node) {

	}

}

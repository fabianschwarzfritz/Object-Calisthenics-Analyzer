package ocanalyzer.rules.r5_shortnames;

import ocanalyzer.rules.general.ValidationHandler;
import ocanalyzer.rules.r5_shortnames.determinator.TypeNameDeterminator;
import ocanalyzer.rules.r5_shortnames.determinator.VariableNameDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

public class ShortNamesVisitor extends ASTVisitor {

	private TypeNameDeterminator typeNameDeterminator;
	private VariableNameDeterminator variableNameDeterminator;

	public ShortNamesVisitor(ValidationHandler validationHandler) {
		typeNameDeterminator = new TypeNameDeterminator(validationHandler);
		variableNameDeterminator = new VariableNameDeterminator(
				validationHandler);
	}

	@Override
	public void endVisit(TypeDeclaration node) {
		typeNameDeterminator.shortName(node);
	}

	@Override
	public void endVisit(VariableDeclarationFragment node) {
		variableNameDeterminator.shortName(node);
	}

}

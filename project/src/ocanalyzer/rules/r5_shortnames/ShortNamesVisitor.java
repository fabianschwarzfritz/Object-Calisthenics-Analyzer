package ocanalyzer.rules.r5_shortnames;

import ocanalyzer.rules.general.ViolationHandler;
import ocanalyzer.rules.general.ViolationHandlerImpl;
import ocanalyzer.rules.r5_shortnames.determinator.TypeNameDeterminator;
import ocanalyzer.rules.r5_shortnames.determinator.VariableNameDeterminator;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

/**
 * 
 * Visitor for rule: "Don't abbreviate"
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */

class ShortNamesVisitor extends ASTVisitor {

	private TypeNameDeterminator typeNameDeterminator;
	private VariableNameDeterminator variableNameDeterminator;

	public ShortNamesVisitor(ViolationHandler violationHandler) {
		typeNameDeterminator = new TypeNameDeterminator(violationHandler);
		variableNameDeterminator = new VariableNameDeterminator(
				violationHandler);
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

package ocanalyzer.rules.r9_properties;

import ocanalyzer.rules.general.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;

/**
 * 
 * This class is used to visit all if {@link Statement}.
 * 
 * An if {@link Statement} which does have a corresponding else
 * {@link Statement} is saved and furthermore it is reported to the given
 * {@link PropertiesValidationHandler}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class PropertiesVisitor extends ASTVisitor {

	private ValidationHandler validationHandler;

	public PropertiesVisitor(ValidationHandler validatonHandler) {
		this.validationHandler = validatonHandler;
	}

}

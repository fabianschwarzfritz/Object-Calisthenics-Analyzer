package ocanalyzer.rules.indentation;

import java.util.ArrayList;
import java.util.List;

import ocanalyzer.rules.ValidationHandler;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.Statement;

public class IndentationVisitor extends ASTVisitor {

	private List<Statement> indentationStatement;
	private ValidationHandler validationHandler;

	public IndentationVisitor(IndentationValidationHandler validationHandler) {
		this.validationHandler = validationHandler;
		indentationStatement = new ArrayList<Statement>();
	}

	@Override
	public void endVisit(IfStatement ifStatement) {
	}

	public List<Statement> getIndentationStatements() {
		return indentationStatement;
	}

}

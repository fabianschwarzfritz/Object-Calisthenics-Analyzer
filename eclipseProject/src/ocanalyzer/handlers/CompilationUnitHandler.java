package ocanalyzer.handlers;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

/**
 * 
 * This class creates the AST tree of a Java class to examine.
 * 
 * Therefore the {@link #handle()} method creates an AST tree and adds all
 * visitors to the Java class's {@link CompilationUnit}
 * 
 * @author Fabian Schwarz-Fritz
 * 
 */
public class CompilationUnitHandler {

	private ICompilationUnit unit;
	private CompilationUnit compilationUnit;
	private MyReporter reporter;

	public CompilationUnitHandler(ICompilationUnit unit) {
		this.unit = unit;
		reporter = new MyReporter();
	}

	public void handle() {
		compilationUnit = (CompilationUnit) new ASTNodeFactory().parse(unit);
		addCompilationUnitVisitors();
	}

	private void addCompilationUnitVisitors() {
		compilationUnit.accept(createElseVisitor());
	}

	private ElseVisitor createElseVisitor() {
		ElseValidationHandler elseValidationHandler = new ElseValidationHandler(
				unit, compilationUnit, reporter);
		ElseVisitor visitor = new ElseVisitor(elseValidationHandler);
		return visitor;
	}
}

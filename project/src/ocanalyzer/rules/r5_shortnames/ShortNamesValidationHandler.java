package ocanalyzer.rules.r5_shortnames;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.general.ValidationHandlerImpl;

public class ShortNamesValidationHandler extends ValidationHandlerImpl {

	public ShortNamesValidationHandler(ICompilationUnit unit,
			CompilationUnit compilationUnit, ClassReporter reporter) {
		super(unit, compilationUnit, reporter);
	}

	@Override
	public void printInfo(ASTNode node) {
		String msg = "No Abbreviations but short names!";
		reportError(msg, node);
	}

}

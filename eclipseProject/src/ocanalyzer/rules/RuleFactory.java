package ocanalyzer.rules;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.rules.indentation.IndentationRuleFactory;
import ocanalyzer.rules.noelse.ElseRuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleFactory {

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected RuleViolationReporter reporter;

	public RuleFactory(ICompilationUnit unit, CompilationUnit compilationUnit,
			RuleViolationReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
	}

	public ASTVisitor createElseRule() {
		ElseRuleFactory elseRuleFactory = new ElseRuleFactory(unit,
				compilationUnit, reporter);
		return elseRuleFactory.create();
	}

	public ASTVisitor createIndentiationRule() {
		IndentationRuleFactory indentationFactory = new IndentationRuleFactory(
				unit, compilationUnit);
		return indentationFactory.create();
	}

}

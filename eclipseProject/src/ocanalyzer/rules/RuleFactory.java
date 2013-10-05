package ocanalyzer.rules;

import ocanalyzer.reporter.RuleViolationReporter;
import ocanalyzer.reporter.StandardReporter;
import ocanalyzer.rules.indentation.IndentationRuleFactory;
import ocanalyzer.rules.noelse.ElseRuleFactory;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class RuleFactory {

	private ElseRuleFactory elseRuleFactory;
	private IndentationRuleFactory indentationRuleFactory;

	protected ICompilationUnit unit;
	protected CompilationUnit compilationUnit;
	protected RuleViolationReporter reporter;

	public RuleFactory(ICompilationUnit unit, CompilationUnit compilationUnit) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = new StandardReporter();
	}

	public RuleFactory(ICompilationUnit unit, CompilationUnit compilationUnit,
			RuleViolationReporter reporter) {
		super();
		this.unit = unit;
		this.compilationUnit = compilationUnit;
		this.reporter = reporter;
		elseRuleFactory = new ElseRuleFactory(unit, compilationUnit, reporter);
		indentationRuleFactory = new IndentationRuleFactory(unit,
				compilationUnit, reporter);
	}

	public ASTVisitor createElseRule() {
		return elseRuleFactory.create();
	}

	public ASTVisitor createIndentiationRule() {
		return indentationRuleFactory.create();
	}

}

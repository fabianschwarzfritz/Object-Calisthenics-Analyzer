package ocanalyzer.rules.impl;

import java.util.Collection;

import ocanalyzer.reporter.ClassReporter;
import ocanalyzer.rules.OCRule;
import ocanalyzer.rules.OCRules;
import ocanalyzer.rules.r1_indentation.RuleIndentation;
import ocanalyzer.rules.r2_noelse.RuleElse;
import ocanalyzer.rules.r3_8_wrap.primitives.RuleWrapPrimitives;
import ocanalyzer.rules.r4_onedot.RuleOneDotPerLine;
import ocanalyzer.rules.r6_small.RuleSmallEntities;
import ocanalyzer.rules.r7_instanceVariable.RuleInstanceVariable;
import ocanalyzer.rules.r8_wrapCollections.RuleWrapCollections;

import org.eclipse.jdt.core.ICompilationUnit;

public class OCRulesImpl implements OCRules {

	public Collection<OCRule> rules;

	private OCRulesImpl() {
	}

	public static OCRulesImpl create() {
		return new OCRulesImpl();
	}

	public static OCRulesImpl createStandardRules(ClassReporter reporter) {
		OCRulesImpl rules = new OCRulesImpl();
		rules.add(new RuleIndentation(reporter));
		rules.add(new RuleElse(reporter));
		rules.add(new RuleWrapPrimitives(reporter));
		rules.add(new RuleOneDotPerLine(reporter));
		rules.add(new RuleSmallEntities(reporter));
		rules.add(new RuleInstanceVariable(reporter));
		rules.add(new RuleWrapCollections(reporter));
		return rules;
	}

	public void apply(Collection<ICompilationUnit> compilationUnits) {
		for (OCRule rule : rules) {
			rule.apply(compilationUnits);
		}
	}

	public boolean add(OCRule e) {
		return rules.add(e);
	}

	public void clear() {
		rules.clear();
	}

}
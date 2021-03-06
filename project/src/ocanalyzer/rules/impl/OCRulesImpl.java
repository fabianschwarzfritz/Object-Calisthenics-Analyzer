package ocanalyzer.rules.impl;

import java.util.Collection;
import java.util.HashSet;

import ocanalyzer.reporter.Reporter;
import ocanalyzer.rules.OCRules;
import ocanalyzer.rules.general.ICompilationUnits;
import ocanalyzer.rules.general.OCRule;
import ocanalyzer.rules.r1_indentation.RuleIndentation;
import ocanalyzer.rules.r2_noelse.RuleElse;
import ocanalyzer.rules.r38_wrap.RuleWrapCollections;
import ocanalyzer.rules.r38_wrap.RuleWrapPrimitives;
import ocanalyzer.rules.r4_onedot.RuleOneDotPerLine;
import ocanalyzer.rules.r5_shortnames.RuleShortNames;
import ocanalyzer.rules.r6_small.RuleSmallEntities;
import ocanalyzer.rules.r7_instanceVariable.RuleInstanceVariable;
import ocanalyzer.rules.r9_properties.RuleProperties;

public class OCRulesImpl implements OCRules {

	public Collection<OCRule> rules;

	private OCRulesImpl() {
		rules = new HashSet<OCRule>();
	}

	public static OCRulesImpl create() {
		return new OCRulesImpl();
	}

	public static OCRulesImpl createStandardRules(Reporter reporter) {
		OCRulesImpl rules = new OCRulesImpl();
		rules.add(new RuleIndentation(reporter));
		rules.add(new RuleElse(reporter));
		rules.add(new RuleWrapPrimitives(reporter));
		rules.add(new RuleOneDotPerLine(reporter));
		rules.add(new RuleShortNames(reporter));
		rules.add(new RuleSmallEntities(reporter));
		rules.add(new RuleInstanceVariable(reporter));
		rules.add(new RuleWrapCollections(reporter));
		rules.add(new RuleProperties(reporter));
		return rules;
	}

	public void apply(ICompilationUnits compilationUnits) {
		for (OCRule rule : rules) {
//			long start = System.nanoTime();
			rule.apply(compilationUnits);
//			long time = System.nanoTime() - start;
//			System.err.println("Rule " + rule + " took " + time + "ns.  = "
//					+ (double) time / 1000000000.0 + "s.");
		}
	}

	public boolean add(OCRule e) {
		return rules.add(e);
	}

	public void clear() {
		rules.clear();
	}

}

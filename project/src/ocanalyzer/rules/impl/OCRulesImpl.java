package ocanalyzer.rules.impl;

import java.util.Collection;

import ocanalyzer.rules.OCRule;
import ocanalyzer.rules.OCRules;

import org.eclipse.jdt.core.ICompilationUnit;

public class OCRulesImpl implements OCRules {

	public Collection<OCRule> rules;

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

package ocanalyzer.rules.impl;

import java.util.Collection;

import org.eclipse.jdt.core.dom.CompilationUnit;

import ocanalyzer.rules.Rule;

public class RulesImpl {

	public Collection<Rule> rules;

	public void apply(Collection<CompilationUnit> compilationUnits) {
		for (Rule rule : rules) {
			rule.apply(compilationUnits);
		}
	}

	public boolean add(Rule e) {
		return rules.add(e);
	}

	public void clear() {
		rules.clear();
	}

}

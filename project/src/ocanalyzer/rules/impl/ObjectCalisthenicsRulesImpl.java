package ocanalyzer.rules.impl;

import java.util.Collection;

import org.eclipse.jdt.core.dom.CompilationUnit;

import ocanalyzer.rules.ObjectCalisthenicsRule;

public class ObjectCalisthenicsRulesImpl {

	public Collection<ObjectCalisthenicsRule> rules;

	public void apply(Collection<CompilationUnit> compilationUnits) {
		for (ObjectCalisthenicsRule rule : rules) {
			rule.apply(compilationUnits);
		}
	}

	public boolean add(ObjectCalisthenicsRule e) {
		return rules.add(e);
	}

	public void clear() {
		rules.clear();
	}

}

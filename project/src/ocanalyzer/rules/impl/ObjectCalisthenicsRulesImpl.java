package ocanalyzer.rules.impl;

import java.util.Collection;

import ocanalyzer.rules.ObjectCalisthenicsRule;
import ocanalyzer.rules.ObjectCalisthenicsRules;

import org.eclipse.jdt.core.ICompilationUnit;

public class ObjectCalisthenicsRulesImpl implements ObjectCalisthenicsRules {

	public Collection<ObjectCalisthenicsRule> rules;

	public void apply(Collection<ICompilationUnit> compilationUnits) {
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

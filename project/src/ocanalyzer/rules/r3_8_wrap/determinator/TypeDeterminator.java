package ocanalyzer.rules.r3_8_wrap.determinator;

import java.util.Set;

import org.eclipse.jdt.core.dom.ITypeBinding;

public abstract class TypeDeterminator {

	public abstract boolean determineType(ITypeBinding resolveTypeBinding);

	public boolean isType(ITypeBinding resolveTypeBinding, String typeName) {
		return resolveTypeBinding.getBinaryName().equals(typeName);
	}

	public boolean isPermittedType(ITypeBinding resolveTypeBinding,
			Set<String> wrapperNames) {
		for (String typeName : wrapperNames) {
			if (isType(resolveTypeBinding, typeName)) {
				return true;
			}
		}

		ITypeBinding superclass = resolveTypeBinding.getSuperclass();
		if (superclass == null || isType(superclass, "Object")) {
			return false;
		}
		return isPermittedType(superclass, wrapperNames);
	}

}

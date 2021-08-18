package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.RetrospectiveEffect;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @version ${project.version}
 */
@RosettaMeta(model=RetrospectiveEffect.class)
public class RetrospectiveEffectMeta implements RosettaMetaData<RetrospectiveEffect> {

	@Override
	public List<Validator<? super RetrospectiveEffect>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super RetrospectiveEffect>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RetrospectiveEffect, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RetrospectiveEffect> validator() {
		return new cdm.legalagreement.csa.validation.RetrospectiveEffectValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RetrospectiveEffect, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.RetrospectiveEffectOnlyExistsValidator();
	}
}

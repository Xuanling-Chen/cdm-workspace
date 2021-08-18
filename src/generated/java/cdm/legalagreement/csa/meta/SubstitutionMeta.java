package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.Substitution;
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
@RosettaMeta(model=Substitution.class)
public class SubstitutionMeta implements RosettaMetaData<Substitution> {

	@Override
	public List<Validator<? super Substitution>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Substitution>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Substitution, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Substitution> validator() {
		return new cdm.legalagreement.csa.validation.SubstitutionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Substitution, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.SubstitutionOnlyExistsValidator();
	}
}

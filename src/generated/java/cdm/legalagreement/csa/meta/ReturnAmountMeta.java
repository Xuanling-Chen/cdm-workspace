package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ReturnAmount;
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
@RosettaMeta(model=ReturnAmount.class)
public class ReturnAmountMeta implements RosettaMetaData<ReturnAmount> {

	@Override
	public List<Validator<? super ReturnAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.ReturnAmountCustomElection.class)
		);
	}

	@Override
	public List<Validator<? super ReturnAmount>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReturnAmount> validator() {
		return new cdm.legalagreement.csa.validation.ReturnAmountValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnAmount, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ReturnAmountOnlyExistsValidator();
	}
}

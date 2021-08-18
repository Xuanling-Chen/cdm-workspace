package cdm.product.asset.meta;

import cdm.product.asset.FloatingAmountProvisions;
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
@RosettaMeta(model=FloatingAmountProvisions.class)
public class FloatingAmountProvisionsMeta implements RosettaMetaData<FloatingAmountProvisions> {

	@Override
	public List<Validator<? super FloatingAmountProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FloatingAmountProvisions>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingAmountProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingAmountProvisions> validator() {
		return new cdm.product.asset.validation.FloatingAmountProvisionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingAmountProvisions, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.FloatingAmountProvisionsOnlyExistsValidator();
	}
}

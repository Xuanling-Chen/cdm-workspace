package cdm.product.template.meta;

import cdm.product.template.CollateralProvisions;
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
@RosettaMeta(model=CollateralProvisions.class)
public class CollateralProvisionsMeta implements RosettaMetaData<CollateralProvisions> {

	@Override
	public List<Validator<? super CollateralProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CollateralProvisions>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralProvisions> validator() {
		return new cdm.product.template.validation.CollateralProvisionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralProvisions, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.CollateralProvisionsOnlyExistsValidator();
	}
}

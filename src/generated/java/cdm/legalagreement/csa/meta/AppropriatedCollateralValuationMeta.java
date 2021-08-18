package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AppropriatedCollateralValuation;
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
@RosettaMeta(model=AppropriatedCollateralValuation.class)
public class AppropriatedCollateralValuationMeta implements RosettaMetaData<AppropriatedCollateralValuation> {

	@Override
	public List<Validator<? super AppropriatedCollateralValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.AppropriatedCollateralValuationSpecified.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.AppropriatedCollateralValuationNotSpecified.class)
		);
	}

	@Override
	public List<Validator<? super AppropriatedCollateralValuation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AppropriatedCollateralValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AppropriatedCollateralValuation> validator() {
		return new cdm.legalagreement.csa.validation.AppropriatedCollateralValuationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AppropriatedCollateralValuation, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AppropriatedCollateralValuationOnlyExistsValidator();
	}
}

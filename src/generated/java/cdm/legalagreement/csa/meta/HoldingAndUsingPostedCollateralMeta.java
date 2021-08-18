package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.HoldingAndUsingPostedCollateral;
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
@RosettaMeta(model=HoldingAndUsingPostedCollateral.class)
public class HoldingAndUsingPostedCollateralMeta implements RosettaMetaData<HoldingAndUsingPostedCollateral> {

	@Override
	public List<Validator<? super HoldingAndUsingPostedCollateral>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super HoldingAndUsingPostedCollateral>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super HoldingAndUsingPostedCollateral, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HoldingAndUsingPostedCollateral> validator() {
		return new cdm.legalagreement.csa.validation.HoldingAndUsingPostedCollateralValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HoldingAndUsingPostedCollateral, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.HoldingAndUsingPostedCollateralOnlyExistsValidator();
	}
}

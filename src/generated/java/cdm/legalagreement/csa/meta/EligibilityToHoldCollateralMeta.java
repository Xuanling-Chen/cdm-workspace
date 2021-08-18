package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.EligibilityToHoldCollateral;
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
@RosettaMeta(model=EligibilityToHoldCollateral.class)
public class EligibilityToHoldCollateralMeta implements RosettaMetaData<EligibilityToHoldCollateral> {

	@Override
	public List<Validator<? super EligibilityToHoldCollateral>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EligibilityToHoldCollateral>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EligibilityToHoldCollateral, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EligibilityToHoldCollateral> validator() {
		return new cdm.legalagreement.csa.validation.EligibilityToHoldCollateralValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EligibilityToHoldCollateral, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.EligibilityToHoldCollateralOnlyExistsValidator();
	}
}

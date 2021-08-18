package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.HoldingAndUsingPostedCollateralElection;
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
@RosettaMeta(model=HoldingAndUsingPostedCollateralElection.class)
public class HoldingAndUsingPostedCollateralElectionMeta implements RosettaMetaData<HoldingAndUsingPostedCollateralElection> {

	@Override
	public List<Validator<? super HoldingAndUsingPostedCollateralElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super HoldingAndUsingPostedCollateralElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super HoldingAndUsingPostedCollateralElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HoldingAndUsingPostedCollateralElection> validator() {
		return new cdm.legalagreement.csa.validation.HoldingAndUsingPostedCollateralElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HoldingAndUsingPostedCollateralElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.HoldingAndUsingPostedCollateralElectionOnlyExistsValidator();
	}
}

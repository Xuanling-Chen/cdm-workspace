package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CollateralTransferAgreementElections;
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
@RosettaMeta(model=CollateralTransferAgreementElections.class)
public class CollateralTransferAgreementElectionsMeta implements RosettaMetaData<CollateralTransferAgreementElections> {

	@Override
	public List<Validator<? super CollateralTransferAgreementElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CollateralTransferAgreementElections>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralTransferAgreementElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralTransferAgreementElections> validator() {
		return new cdm.legalagreement.csa.validation.CollateralTransferAgreementElectionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralTransferAgreementElections, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CollateralTransferAgreementElectionsOnlyExistsValidator();
	}
}

package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CollateralManagementAgreement;
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
@RosettaMeta(model=CollateralManagementAgreement.class)
public class CollateralManagementAgreementMeta implements RosettaMetaData<CollateralManagementAgreement> {

	@Override
	public List<Validator<? super CollateralManagementAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CollateralManagementAgreement>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralManagementAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralManagementAgreement> validator() {
		return new cdm.legalagreement.csa.validation.CollateralManagementAgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralManagementAgreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CollateralManagementAgreementOnlyExistsValidator();
	}
}

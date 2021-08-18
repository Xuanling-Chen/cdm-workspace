package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.DistributionAndInterestPayment;
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
@RosettaMeta(model=DistributionAndInterestPayment.class)
public class DistributionAndInterestPaymentMeta implements RosettaMetaData<DistributionAndInterestPayment> {

	@Override
	public List<Validator<? super DistributionAndInterestPayment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DistributionAndInterestPayment>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DistributionAndInterestPayment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DistributionAndInterestPayment> validator() {
		return new cdm.legalagreement.csa.validation.DistributionAndInterestPaymentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DistributionAndInterestPayment, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.DistributionAndInterestPaymentOnlyExistsValidator();
	}
}

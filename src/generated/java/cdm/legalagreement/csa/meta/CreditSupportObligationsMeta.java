package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CreditSupportObligations;
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
@RosettaMeta(model=CreditSupportObligations.class)
public class CreditSupportObligationsMeta implements RosettaMetaData<CreditSupportObligations> {

	@Override
	public List<Validator<? super CreditSupportObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CreditSupportObligations>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportObligations> validator() {
		return new cdm.legalagreement.csa.validation.CreditSupportObligationsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportObligations, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CreditSupportObligationsOnlyExistsValidator();
	}
}

package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.CreditSupportProvider;
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
@RosettaMeta(model=CreditSupportProvider.class)
public class CreditSupportProviderMeta implements RosettaMetaData<CreditSupportProvider> {

	@Override
	public List<Validator<? super CreditSupportProvider>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CreditSupportProvider>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportProvider, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportProvider> validator() {
		return new cdm.legalagreement.master.validation.CreditSupportProviderValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportProvider, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.CreditSupportProviderOnlyExistsValidator();
	}
}

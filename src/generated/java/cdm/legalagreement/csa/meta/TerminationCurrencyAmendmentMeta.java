package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.TerminationCurrencyAmendment;
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
@RosettaMeta(model=TerminationCurrencyAmendment.class)
public class TerminationCurrencyAmendmentMeta implements RosettaMetaData<TerminationCurrencyAmendment> {

	@Override
	public List<Validator<? super TerminationCurrencyAmendment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.TerminationCurrencyAmendmentApplicablity.class)
		);
	}

	@Override
	public List<Validator<? super TerminationCurrencyAmendment>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TerminationCurrencyAmendment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TerminationCurrencyAmendment> validator() {
		return new cdm.legalagreement.csa.validation.TerminationCurrencyAmendmentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TerminationCurrencyAmendment, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.TerminationCurrencyAmendmentOnlyExistsValidator();
	}
}

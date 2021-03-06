package cdm.product.template.meta;

import cdm.product.template.MandatoryEarlyTerminationAdjustedDates;
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
@RosettaMeta(model=MandatoryEarlyTerminationAdjustedDates.class)
public class MandatoryEarlyTerminationAdjustedDatesMeta implements RosettaMetaData<MandatoryEarlyTerminationAdjustedDates> {

	@Override
	public List<Validator<? super MandatoryEarlyTerminationAdjustedDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.template.validation.datarule.MandatoryEarlyTerminationAdjustedDatesFpMLIrd44.class)
		);
	}

	@Override
	public List<Validator<? super MandatoryEarlyTerminationAdjustedDates>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MandatoryEarlyTerminationAdjustedDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MandatoryEarlyTerminationAdjustedDates> validator() {
		return new cdm.product.template.validation.MandatoryEarlyTerminationAdjustedDatesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryEarlyTerminationAdjustedDates, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.MandatoryEarlyTerminationAdjustedDatesOnlyExistsValidator();
	}
}

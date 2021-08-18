package cdm.product.template.meta;

import cdm.product.template.MandatoryEarlyTermination;
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
@RosettaMeta(model=MandatoryEarlyTermination.class)
public class MandatoryEarlyTerminationMeta implements RosettaMetaData<MandatoryEarlyTermination> {

	@Override
	public List<Validator<? super MandatoryEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.template.validation.datarule.MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent.class)
		);
	}

	@Override
	public List<Validator<? super MandatoryEarlyTermination>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MandatoryEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MandatoryEarlyTermination> validator() {
		return new cdm.product.template.validation.MandatoryEarlyTerminationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryEarlyTermination, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.MandatoryEarlyTerminationOnlyExistsValidator();
	}
}

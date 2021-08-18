package cdm.event.common.meta;

import cdm.event.common.TransferCalculation;
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
@RosettaMeta(model=TransferCalculation.class)
public class TransferCalculationMeta implements RosettaMetaData<TransferCalculation> {

	@Override
	public List<Validator<? super TransferCalculation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super TransferCalculation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransferCalculation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransferCalculation> validator() {
		return new cdm.event.common.validation.TransferCalculationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransferCalculation, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.TransferCalculationOnlyExistsValidator();
	}
}

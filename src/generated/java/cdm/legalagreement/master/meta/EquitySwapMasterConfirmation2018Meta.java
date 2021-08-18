package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.EquitySwapMasterConfirmation2018;
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
@RosettaMeta(model=EquitySwapMasterConfirmation2018.class)
public class EquitySwapMasterConfirmation2018Meta implements RosettaMetaData<EquitySwapMasterConfirmation2018> {

	@Override
	public List<Validator<? super EquitySwapMasterConfirmation2018>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EquitySwapMasterConfirmation2018>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EquitySwapMasterConfirmation2018, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EquitySwapMasterConfirmation2018> validator() {
		return new cdm.legalagreement.master.validation.EquitySwapMasterConfirmation2018Validator();
	}
	
	@Override
	public ValidatorWithArg<? super EquitySwapMasterConfirmation2018, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.EquitySwapMasterConfirmation2018OnlyExistsValidator();
	}
}

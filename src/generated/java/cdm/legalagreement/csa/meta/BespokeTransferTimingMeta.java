package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.BespokeTransferTiming;
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
@RosettaMeta(model=BespokeTransferTiming.class)
public class BespokeTransferTimingMeta implements RosettaMetaData<BespokeTransferTiming> {

	@Override
	public List<Validator<? super BespokeTransferTiming>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super BespokeTransferTiming>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BespokeTransferTiming, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BespokeTransferTiming> validator() {
		return new cdm.legalagreement.csa.validation.BespokeTransferTimingValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BespokeTransferTiming, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.BespokeTransferTimingOnlyExistsValidator();
	}
}

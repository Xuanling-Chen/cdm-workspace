package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.MinimumTransferAmount;
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
@RosettaMeta(model=MinimumTransferAmount.class)
public class MinimumTransferAmountMeta implements RosettaMetaData<MinimumTransferAmount> {

	@Override
	public List<Validator<? super MinimumTransferAmount>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super MinimumTransferAmount>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MinimumTransferAmount, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MinimumTransferAmount> validator() {
		return new cdm.legalagreement.csa.validation.MinimumTransferAmountValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MinimumTransferAmount, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.MinimumTransferAmountOnlyExistsValidator();
	}
}

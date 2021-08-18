package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.InterestAdjustment;
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
@RosettaMeta(model=InterestAdjustment.class)
public class InterestAdjustmentMeta implements RosettaMetaData<InterestAdjustment> {

	@Override
	public List<Validator<? super InterestAdjustment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super InterestAdjustment>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InterestAdjustment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestAdjustment> validator() {
		return new cdm.legalagreement.csa.validation.InterestAdjustmentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAdjustment, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.InterestAdjustmentOnlyExistsValidator();
	}
}

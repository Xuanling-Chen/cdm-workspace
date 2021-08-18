package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.InterestAdjustmentPeriodicity;
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
@RosettaMeta(model=InterestAdjustmentPeriodicity.class)
public class InterestAdjustmentPeriodicityMeta implements RosettaMetaData<InterestAdjustmentPeriodicity> {

	@Override
	public List<Validator<? super InterestAdjustmentPeriodicity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super InterestAdjustmentPeriodicity>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.InterestAdjustmentPeriodicityOneOf0()
		);
	}
	
	@Override
	public List<Function<? super InterestAdjustmentPeriodicity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InterestAdjustmentPeriodicity> validator() {
		return new cdm.legalagreement.csa.validation.InterestAdjustmentPeriodicityValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InterestAdjustmentPeriodicity, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.InterestAdjustmentPeriodicityOnlyExistsValidator();
	}
}

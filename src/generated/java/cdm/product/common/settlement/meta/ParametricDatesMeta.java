package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.ParametricDates;
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
@RosettaMeta(model=ParametricDates.class)
public class ParametricDatesMeta implements RosettaMetaData<ParametricDates> {

	@Override
	public List<Validator<? super ParametricDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.settlement.validation.datarule.ParametricDatesDayOfWeekMethod.class)
		);
	}

	@Override
	public List<Validator<? super ParametricDates>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.settlement.validation.choicerule.ParametricDatesParametricDatesChoice()
		);
	}
	
	@Override
	public List<Function<? super ParametricDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ParametricDates> validator() {
		return new cdm.product.common.settlement.validation.ParametricDatesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ParametricDates, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.ParametricDatesOnlyExistsValidator();
	}
}

package cdm.product.asset.meta;

import cdm.product.asset.SpreadSchedule;
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
@RosettaMeta(model=SpreadSchedule.class)
public class SpreadScheduleMeta implements RosettaMetaData<SpreadSchedule> {

	@Override
	public List<Validator<? super SpreadSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SpreadSchedule>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpreadSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpreadSchedule> validator() {
		return new cdm.product.asset.validation.SpreadScheduleValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpreadSchedule, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.SpreadScheduleOnlyExistsValidator();
	}
}

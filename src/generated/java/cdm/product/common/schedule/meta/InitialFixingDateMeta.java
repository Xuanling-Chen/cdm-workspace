package cdm.product.common.schedule.meta;

import cdm.product.common.schedule.InitialFixingDate;
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
@RosettaMeta(model=InitialFixingDate.class)
public class InitialFixingDateMeta implements RosettaMetaData<InitialFixingDate> {

	@Override
	public List<Validator<? super InitialFixingDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super InitialFixingDate>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.schedule.validation.choicerule.InitialFixingDateOneOf0()
		);
	}
	
	@Override
	public List<Function<? super InitialFixingDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InitialFixingDate> validator() {
		return new cdm.product.common.schedule.validation.InitialFixingDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InitialFixingDate, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.schedule.validation.exists.InitialFixingDateOnlyExistsValidator();
	}
}

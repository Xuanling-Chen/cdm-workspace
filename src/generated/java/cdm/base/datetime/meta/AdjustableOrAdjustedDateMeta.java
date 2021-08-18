package cdm.base.datetime.meta;

import cdm.base.datetime.AdjustableOrAdjustedDate;
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
@RosettaMeta(model=AdjustableOrAdjustedDate.class)
public class AdjustableOrAdjustedDateMeta implements RosettaMetaData<AdjustableOrAdjustedDate> {

	@Override
	public List<Validator<? super AdjustableOrAdjustedDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.base.datetime.validation.datarule.AdjustableOrAdjustedDateAdjustedDate.class)
		);
	}

	@Override
	public List<Validator<? super AdjustableOrAdjustedDate>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdjustableOrAdjustedDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableOrAdjustedDate> validator() {
		return new cdm.base.datetime.validation.AdjustableOrAdjustedDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableOrAdjustedDate, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.AdjustableOrAdjustedDateOnlyExistsValidator();
	}
}

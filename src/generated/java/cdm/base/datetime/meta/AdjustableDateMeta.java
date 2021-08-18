package cdm.base.datetime.meta;

import cdm.base.datetime.AdjustableDate;
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
@RosettaMeta(model=AdjustableDate.class)
public class AdjustableDateMeta implements RosettaMetaData<AdjustableDate> {

	@Override
	public List<Validator<? super AdjustableDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdjustableDate>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.datetime.validation.choicerule.AdjustableDateAdjustableDateChoice()
		);
	}
	
	@Override
	public List<Function<? super AdjustableDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdjustableDate> validator() {
		return new cdm.base.datetime.validation.AdjustableDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDate, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.AdjustableDateOnlyExistsValidator();
	}
}

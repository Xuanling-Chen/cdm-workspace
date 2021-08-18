package cdm.base.datetime.meta;

import cdm.base.datetime.Offset;
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
@RosettaMeta(model=Offset.class)
public class OffsetMeta implements RosettaMetaData<Offset> {

	@Override
	public List<Validator<? super Offset>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.base.datetime.validation.datarule.OffsetDayType.class)
		);
	}

	@Override
	public List<Validator<? super Offset>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Offset, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Offset> validator() {
		return new cdm.base.datetime.validation.OffsetValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Offset, Set<String>> onlyExistsValidator() {
		return new cdm.base.datetime.validation.exists.OffsetOnlyExistsValidator();
	}
}

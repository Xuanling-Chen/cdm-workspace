package cdm.base.math.meta;

import cdm.base.math.UnitType;
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
@RosettaMeta(model=UnitType.class)
public class UnitTypeMeta implements RosettaMetaData<UnitType> {

	@Override
	public List<Validator<? super UnitType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super UnitType>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.math.validation.choicerule.UnitTypeOneOf0()
		);
	}
	
	@Override
	public List<Function<? super UnitType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnitType> validator() {
		return new cdm.base.math.validation.UnitTypeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnitType, Set<String>> onlyExistsValidator() {
		return new cdm.base.math.validation.exists.UnitTypeOnlyExistsValidator();
	}
}

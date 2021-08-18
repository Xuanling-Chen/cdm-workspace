package cdm.event.common.meta;

import cdm.event.common.SettlementOrigin;
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
@RosettaMeta(model=SettlementOrigin.class)
public class SettlementOriginMeta implements RosettaMetaData<SettlementOrigin> {

	@Override
	public List<Validator<? super SettlementOrigin>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SettlementOrigin>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.event.common.validation.choicerule.SettlementOriginOneOf0()
		);
	}
	
	@Override
	public List<Function<? super SettlementOrigin, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementOrigin> validator() {
		return new cdm.event.common.validation.SettlementOriginValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementOrigin, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.SettlementOriginOnlyExistsValidator();
	}
}

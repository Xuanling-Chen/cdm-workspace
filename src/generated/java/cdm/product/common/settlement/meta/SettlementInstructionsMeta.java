package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.SettlementInstructions;
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
@RosettaMeta(model=SettlementInstructions.class)
public class SettlementInstructionsMeta implements RosettaMetaData<SettlementInstructions> {

	@Override
	public List<Validator<? super SettlementInstructions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SettlementInstructions>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementInstructions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementInstructions> validator() {
		return new cdm.product.common.settlement.validation.SettlementInstructionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementInstructions, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.SettlementInstructionsOnlyExistsValidator();
	}
}

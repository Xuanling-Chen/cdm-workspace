package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.SettlementBase;
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
@RosettaMeta(model=SettlementBase.class)
public class SettlementBaseMeta implements RosettaMetaData<SettlementBase> {

	@Override
	public List<Validator<? super SettlementBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SettlementBase>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementBase> validator() {
		return new cdm.product.common.settlement.validation.SettlementBaseValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementBase, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.SettlementBaseOnlyExistsValidator();
	}
}

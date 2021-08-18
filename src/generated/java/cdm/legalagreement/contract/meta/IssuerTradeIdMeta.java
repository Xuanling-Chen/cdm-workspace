package cdm.legalagreement.contract.meta;

import cdm.legalagreement.contract.IssuerTradeId;
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
@RosettaMeta(model=IssuerTradeId.class)
public class IssuerTradeIdMeta implements RosettaMetaData<IssuerTradeId> {

	@Override
	public List<Validator<? super IssuerTradeId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super IssuerTradeId>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IssuerTradeId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IssuerTradeId> validator() {
		return new cdm.legalagreement.contract.validation.IssuerTradeIdValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IssuerTradeId, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.contract.validation.exists.IssuerTradeIdOnlyExistsValidator();
	}
}

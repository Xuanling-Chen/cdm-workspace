package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.PrincipalExchanges;
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
@RosettaMeta(model=PrincipalExchanges.class)
public class PrincipalExchangesMeta implements RosettaMetaData<PrincipalExchanges> {

	@Override
	public List<Validator<? super PrincipalExchanges>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PrincipalExchanges>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrincipalExchanges, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrincipalExchanges> validator() {
		return new cdm.product.common.settlement.validation.PrincipalExchangesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrincipalExchanges, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.PrincipalExchangesOnlyExistsValidator();
	}
}

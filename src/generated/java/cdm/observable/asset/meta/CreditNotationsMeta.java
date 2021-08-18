package cdm.observable.asset.meta;

import cdm.observable.asset.CreditNotations;
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
@RosettaMeta(model=CreditNotations.class)
public class CreditNotationsMeta implements RosettaMetaData<CreditNotations> {

	@Override
	public List<Validator<? super CreditNotations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CreditNotations>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.asset.validation.choicerule.CreditNotationsOneOf0()
		);
	}
	
	@Override
	public List<Function<? super CreditNotations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditNotations> validator() {
		return new cdm.observable.asset.validation.CreditNotationsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditNotations, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.CreditNotationsOnlyExistsValidator();
	}
}

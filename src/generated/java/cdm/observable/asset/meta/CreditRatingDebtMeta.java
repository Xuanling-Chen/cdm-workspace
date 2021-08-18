package cdm.observable.asset.meta;

import cdm.observable.asset.CreditRatingDebt;
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
@RosettaMeta(model=CreditRatingDebt.class)
public class CreditRatingDebtMeta implements RosettaMetaData<CreditRatingDebt> {

	@Override
	public List<Validator<? super CreditRatingDebt>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CreditRatingDebt>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.asset.validation.choicerule.CreditRatingDebtOneOf0()
		);
	}
	
	@Override
	public List<Function<? super CreditRatingDebt, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditRatingDebt> validator() {
		return new cdm.observable.asset.validation.CreditRatingDebtValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditRatingDebt, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.CreditRatingDebtOnlyExistsValidator();
	}
}

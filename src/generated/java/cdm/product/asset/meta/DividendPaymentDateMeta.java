package cdm.product.asset.meta;

import cdm.product.asset.DividendPaymentDate;
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
@RosettaMeta(model=DividendPaymentDate.class)
public class DividendPaymentDateMeta implements RosettaMetaData<DividendPaymentDate> {

	@Override
	public List<Validator<? super DividendPaymentDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DividendPaymentDate>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.asset.validation.choicerule.DividendPaymentDateOneOf0()
		);
	}
	
	@Override
	public List<Function<? super DividendPaymentDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DividendPaymentDate> validator() {
		return new cdm.product.asset.validation.DividendPaymentDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DividendPaymentDate, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.DividendPaymentDateOnlyExistsValidator();
	}
}

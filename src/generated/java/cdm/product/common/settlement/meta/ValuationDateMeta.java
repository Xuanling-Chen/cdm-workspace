package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.ValuationDate;
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
@RosettaMeta(model=ValuationDate.class)
public class ValuationDateMeta implements RosettaMetaData<ValuationDate> {

	@Override
	public List<Validator<? super ValuationDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ValuationDate>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.settlement.validation.choicerule.ValuationDateOneOf0()
		);
	}
	
	@Override
	public List<Function<? super ValuationDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationDate> validator() {
		return new cdm.product.common.settlement.validation.ValuationDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationDate, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.ValuationDateOnlyExistsValidator();
	}
}

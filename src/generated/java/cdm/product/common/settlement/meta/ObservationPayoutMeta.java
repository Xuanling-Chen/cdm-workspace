package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.ObservationPayout;
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
@RosettaMeta(model=ObservationPayout.class)
public class ObservationPayoutMeta implements RosettaMetaData<ObservationPayout> {

	@Override
	public List<Validator<? super ObservationPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ObservationPayout>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObservationPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObservationPayout> validator() {
		return new cdm.product.common.settlement.validation.ObservationPayoutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObservationPayout, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.ObservationPayoutOnlyExistsValidator();
	}
}

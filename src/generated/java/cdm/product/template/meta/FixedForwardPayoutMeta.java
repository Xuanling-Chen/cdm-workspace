package cdm.product.template.meta;

import cdm.product.template.FixedForwardPayout;
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
@RosettaMeta(model=FixedForwardPayout.class)
public class FixedForwardPayoutMeta implements RosettaMetaData<FixedForwardPayout> {

	@Override
	public List<Validator<? super FixedForwardPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FixedForwardPayout>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FixedForwardPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FixedForwardPayout> validator() {
		return new cdm.product.template.validation.FixedForwardPayoutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FixedForwardPayout, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.FixedForwardPayoutOnlyExistsValidator();
	}
}

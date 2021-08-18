package cdm.product.template.meta;

import cdm.product.template.OptionPayout;
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
@RosettaMeta(model=OptionPayout.class)
public class OptionPayoutMeta implements RosettaMetaData<OptionPayout> {

	@Override
	public List<Validator<? super OptionPayout>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.template.validation.datarule.OptionPayoutDataRule0.class)
		);
	}

	@Override
	public List<Validator<? super OptionPayout>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionPayout, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionPayout> validator() {
		return new cdm.product.template.validation.OptionPayoutValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionPayout, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.OptionPayoutOnlyExistsValidator();
	}
}

package cdm.product.template.meta;

import cdm.product.template.OptionStyle;
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
@RosettaMeta(model=OptionStyle.class)
public class OptionStyleMeta implements RosettaMetaData<OptionStyle> {

	@Override
	public List<Validator<? super OptionStyle>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super OptionStyle>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.template.validation.choicerule.OptionStyleOneOf0()
		);
	}
	
	@Override
	public List<Function<? super OptionStyle, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionStyle> validator() {
		return new cdm.product.template.validation.OptionStyleValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionStyle, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.OptionStyleOnlyExistsValidator();
	}
}

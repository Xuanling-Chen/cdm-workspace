package cdm.product.template.meta;

import cdm.product.template.OptionProvision;
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
@RosettaMeta(model=OptionProvision.class)
public class OptionProvisionMeta implements RosettaMetaData<OptionProvision> {

	@Override
	public List<Validator<? super OptionProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super OptionProvision>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionProvision> validator() {
		return new cdm.product.template.validation.OptionProvisionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionProvision, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.OptionProvisionOnlyExistsValidator();
	}
}

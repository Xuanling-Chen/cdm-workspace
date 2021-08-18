package cdm.product.template.meta;

import cdm.product.template.EvergreenProvision;
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
@RosettaMeta(model=EvergreenProvision.class)
public class EvergreenProvisionMeta implements RosettaMetaData<EvergreenProvision> {

	@Override
	public List<Validator<? super EvergreenProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EvergreenProvision>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.template.validation.choicerule.EvergreenProvisionExerciseChoice()
		);
	}
	
	@Override
	public List<Function<? super EvergreenProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EvergreenProvision> validator() {
		return new cdm.product.template.validation.EvergreenProvisionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EvergreenProvision, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.EvergreenProvisionOnlyExistsValidator();
	}
}

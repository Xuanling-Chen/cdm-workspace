package cdm.product.template.meta;

import cdm.product.template.CancelableProvision;
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
@RosettaMeta(model=CancelableProvision.class)
public class CancelableProvisionMeta implements RosettaMetaData<CancelableProvision> {

	@Override
	public List<Validator<? super CancelableProvision>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.template.validation.datarule.CancelableProvisionCancelableProvisionExerciseNoticeReceiverParty.class)
		);
	}

	@Override
	public List<Validator<? super CancelableProvision>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.template.validation.choicerule.CancelableProvisionExerciseChoice()
		);
	}
	
	@Override
	public List<Function<? super CancelableProvision, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CancelableProvision> validator() {
		return new cdm.product.template.validation.CancelableProvisionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CancelableProvision, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.CancelableProvisionOnlyExistsValidator();
	}
}

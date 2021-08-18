package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.Resource;
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
@RosettaMeta(model=Resource.class)
public class ResourceMeta implements RosettaMetaData<Resource> {

	@Override
	public List<Validator<? super Resource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Resource>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.common.validation.choicerule.ResourceResourceChoice()
		);
	}
	
	@Override
	public List<Function<? super Resource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Resource> validator() {
		return new cdm.legalagreement.common.validation.ResourceValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Resource, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.ResourceOnlyExistsValidator();
	}
}

package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.ResourceLength;
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
@RosettaMeta(model=ResourceLength.class)
public class ResourceLengthMeta implements RosettaMetaData<ResourceLength> {

	@Override
	public List<Validator<? super ResourceLength>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ResourceLength>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ResourceLength, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResourceLength> validator() {
		return new cdm.legalagreement.common.validation.ResourceLengthValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResourceLength, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.ResourceLengthOnlyExistsValidator();
	}
}

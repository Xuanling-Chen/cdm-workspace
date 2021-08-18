package cdm.legalagreement.common.meta;

import cdm.legalagreement.common.DocumentationIdentification;
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
@RosettaMeta(model=DocumentationIdentification.class)
public class DocumentationIdentificationMeta implements RosettaMetaData<DocumentationIdentification> {

	@Override
	public List<Validator<? super DocumentationIdentification>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super DocumentationIdentification>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.common.validation.choicerule.DocumentationIdentificationConfirmationChoice()
		);
	}
	
	@Override
	public List<Function<? super DocumentationIdentification, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DocumentationIdentification> validator() {
		return new cdm.legalagreement.common.validation.DocumentationIdentificationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DocumentationIdentification, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.common.validation.exists.DocumentationIdentificationOnlyExistsValidator();
	}
}

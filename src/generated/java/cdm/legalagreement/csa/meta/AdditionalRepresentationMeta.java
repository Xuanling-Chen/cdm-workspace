package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AdditionalRepresentation;
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
@RosettaMeta(model=AdditionalRepresentation.class)
public class AdditionalRepresentationMeta implements RosettaMetaData<AdditionalRepresentation> {

	@Override
	public List<Validator<? super AdditionalRepresentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdditionalRepresentation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalRepresentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalRepresentation> validator() {
		return new cdm.legalagreement.csa.validation.AdditionalRepresentationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalRepresentation, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AdditionalRepresentationOnlyExistsValidator();
	}
}

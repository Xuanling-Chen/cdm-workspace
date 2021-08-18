package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AdditionalRepresentations;
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
@RosettaMeta(model=AdditionalRepresentations.class)
public class AdditionalRepresentationsMeta implements RosettaMetaData<AdditionalRepresentations> {

	@Override
	public List<Validator<? super AdditionalRepresentations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AdditionalRepresentations>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.AdditionalRepresentationsOneOf0()
		);
	}
	
	@Override
	public List<Function<? super AdditionalRepresentations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalRepresentations> validator() {
		return new cdm.legalagreement.csa.validation.AdditionalRepresentationsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalRepresentations, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AdditionalRepresentationsOnlyExistsValidator();
	}
}

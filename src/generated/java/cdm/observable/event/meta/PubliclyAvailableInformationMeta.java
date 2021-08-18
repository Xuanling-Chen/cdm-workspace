package cdm.observable.event.meta;

import cdm.observable.event.PubliclyAvailableInformation;
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
@RosettaMeta(model=PubliclyAvailableInformation.class)
public class PubliclyAvailableInformationMeta implements RosettaMetaData<PubliclyAvailableInformation> {

	@Override
	public List<Validator<? super PubliclyAvailableInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.observable.event.validation.datarule.PubliclyAvailableInformationPositiveSpecifiedNumber.class)
		);
	}

	@Override
	public List<Validator<? super PubliclyAvailableInformation>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.observable.event.validation.choicerule.PubliclyAvailableInformationSourceChoice()
		);
	}
	
	@Override
	public List<Function<? super PubliclyAvailableInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PubliclyAvailableInformation> validator() {
		return new cdm.observable.event.validation.PubliclyAvailableInformationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PubliclyAvailableInformation, Set<String>> onlyExistsValidator() {
		return new cdm.observable.event.validation.exists.PubliclyAvailableInformationOnlyExistsValidator();
	}
}

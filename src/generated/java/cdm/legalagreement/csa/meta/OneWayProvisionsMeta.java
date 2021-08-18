package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.OneWayProvisions;
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
@RosettaMeta(model=OneWayProvisions.class)
public class OneWayProvisionsMeta implements RosettaMetaData<OneWayProvisions> {

	@Override
	public List<Validator<? super OneWayProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.OneWayProvisionsPostingPartyExists.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.OneWayProvisionsPostingPartyAbsent.class)
		);
	}

	@Override
	public List<Validator<? super OneWayProvisions>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OneWayProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OneWayProvisions> validator() {
		return new cdm.legalagreement.csa.validation.OneWayProvisionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OneWayProvisions, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.OneWayProvisionsOnlyExistsValidator();
	}
}

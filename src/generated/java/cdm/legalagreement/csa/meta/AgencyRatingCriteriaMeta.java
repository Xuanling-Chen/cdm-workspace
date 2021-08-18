package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AgencyRatingCriteria;
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
@RosettaMeta(model=AgencyRatingCriteria.class)
public class AgencyRatingCriteriaMeta implements RosettaMetaData<AgencyRatingCriteria> {

	@Override
	public List<Validator<? super AgencyRatingCriteria>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.AgencyRatingCriteriaReferenceAgency.class)
		);
	}

	@Override
	public List<Validator<? super AgencyRatingCriteria>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AgencyRatingCriteria, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AgencyRatingCriteria> validator() {
		return new cdm.legalagreement.csa.validation.AgencyRatingCriteriaValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AgencyRatingCriteria, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AgencyRatingCriteriaOnlyExistsValidator();
	}
}

package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.FrenchLawAddendum;
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
@RosettaMeta(model=FrenchLawAddendum.class)
public class FrenchLawAddendumMeta implements RosettaMetaData<FrenchLawAddendum> {

	@Override
	public List<Validator<? super FrenchLawAddendum>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.FrenchLawAddendumApplicable.class)
		);
	}

	@Override
	public List<Validator<? super FrenchLawAddendum>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FrenchLawAddendum, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FrenchLawAddendum> validator() {
		return new cdm.legalagreement.csa.validation.FrenchLawAddendumValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FrenchLawAddendum, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.FrenchLawAddendumOnlyExistsValidator();
	}
}

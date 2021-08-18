package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.FrenchLawAddendumElection;
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
@RosettaMeta(model=FrenchLawAddendumElection.class)
public class FrenchLawAddendumElectionMeta implements RosettaMetaData<FrenchLawAddendumElection> {

	@Override
	public List<Validator<? super FrenchLawAddendumElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.FrenchLawAddendumElectionAddendumLanguage.class)
		);
	}

	@Override
	public List<Validator<? super FrenchLawAddendumElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FrenchLawAddendumElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FrenchLawAddendumElection> validator() {
		return new cdm.legalagreement.csa.validation.FrenchLawAddendumElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FrenchLawAddendumElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.FrenchLawAddendumElectionOnlyExistsValidator();
	}
}

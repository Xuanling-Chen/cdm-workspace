package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.GeneralSimmElections;
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
@RosettaMeta(model=GeneralSimmElections.class)
public class GeneralSimmElectionsMeta implements RosettaMetaData<GeneralSimmElections> {

	@Override
	public List<Validator<? super GeneralSimmElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super GeneralSimmElections>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GeneralSimmElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GeneralSimmElections> validator() {
		return new cdm.legalagreement.csa.validation.GeneralSimmElectionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GeneralSimmElections, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.GeneralSimmElectionsOnlyExistsValidator();
	}
}

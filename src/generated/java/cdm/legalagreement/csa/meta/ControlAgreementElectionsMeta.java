package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ControlAgreementElections;
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
@RosettaMeta(model=ControlAgreementElections.class)
public class ControlAgreementElectionsMeta implements RosettaMetaData<ControlAgreementElections> {

	@Override
	public List<Validator<? super ControlAgreementElections>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ControlAgreementElections>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ControlAgreementElections, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ControlAgreementElections> validator() {
		return new cdm.legalagreement.csa.validation.ControlAgreementElectionsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ControlAgreementElections, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ControlAgreementElectionsOnlyExistsValidator();
	}
}

package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.PartyAgreementIdentifier;
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
@RosettaMeta(model=PartyAgreementIdentifier.class)
public class PartyAgreementIdentifierMeta implements RosettaMetaData<PartyAgreementIdentifier> {

	@Override
	public List<Validator<? super PartyAgreementIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PartyAgreementIdentifier>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyAgreementIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyAgreementIdentifier> validator() {
		return new cdm.legalagreement.csa.validation.PartyAgreementIdentifierValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyAgreementIdentifier, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.PartyAgreementIdentifierOnlyExistsValidator();
	}
}

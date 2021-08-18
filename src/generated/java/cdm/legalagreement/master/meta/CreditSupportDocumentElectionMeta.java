package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.CreditSupportDocumentElection;
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
@RosettaMeta(model=CreditSupportDocumentElection.class)
public class CreditSupportDocumentElectionMeta implements RosettaMetaData<CreditSupportDocumentElection> {

	@Override
	public List<Validator<? super CreditSupportDocumentElection>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.master.validation.datarule.CreditSupportDocumentElectionCreditSupportDocument.class)
		);
	}

	@Override
	public List<Validator<? super CreditSupportDocumentElection>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditSupportDocumentElection, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditSupportDocumentElection> validator() {
		return new cdm.legalagreement.master.validation.CreditSupportDocumentElectionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditSupportDocumentElection, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.CreditSupportDocumentElectionOnlyExistsValidator();
	}
}

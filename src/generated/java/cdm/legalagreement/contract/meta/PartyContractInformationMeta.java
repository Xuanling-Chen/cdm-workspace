package cdm.legalagreement.contract.meta;

import cdm.legalagreement.contract.PartyContractInformation;
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
@RosettaMeta(model=PartyContractInformation.class)
public class PartyContractInformationMeta implements RosettaMetaData<PartyContractInformation> {

	@Override
	public List<Validator<? super PartyContractInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PartyContractInformation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PartyContractInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PartyContractInformation> validator() {
		return new cdm.legalagreement.contract.validation.PartyContractInformationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyContractInformation, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.contract.validation.exists.PartyContractInformationOnlyExistsValidator();
	}
}

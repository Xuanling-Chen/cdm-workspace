package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.MasterAgreement;
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
@RosettaMeta(model=MasterAgreement.class)
public class MasterAgreementMeta implements RosettaMetaData<MasterAgreement> {

	@Override
	public List<Validator<? super MasterAgreement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super MasterAgreement>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MasterAgreement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MasterAgreement> validator() {
		return new cdm.legalagreement.master.validation.MasterAgreementValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MasterAgreement, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.MasterAgreementOnlyExistsValidator();
	}
}

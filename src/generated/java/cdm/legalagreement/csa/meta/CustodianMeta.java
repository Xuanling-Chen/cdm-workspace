package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.Custodian;
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
@RosettaMeta(model=Custodian.class)
public class CustodianMeta implements RosettaMetaData<Custodian> {

	@Override
	public List<Validator<? super Custodian>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Custodian>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Custodian, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Custodian> validator() {
		return new cdm.legalagreement.csa.validation.CustodianValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Custodian, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CustodianOnlyExistsValidator();
	}
}

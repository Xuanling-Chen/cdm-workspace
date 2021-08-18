package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CustodianRisk;
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
@RosettaMeta(model=CustodianRisk.class)
public class CustodianRiskMeta implements RosettaMetaData<CustodianRisk> {

	@Override
	public List<Validator<? super CustodianRisk>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CustodianRisk>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianRisk, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianRisk> validator() {
		return new cdm.legalagreement.csa.validation.CustodianRiskValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianRisk, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CustodianRiskOnlyExistsValidator();
	}
}

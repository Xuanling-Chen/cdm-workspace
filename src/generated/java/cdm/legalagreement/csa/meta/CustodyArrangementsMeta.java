package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CustodyArrangements;
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
@RosettaMeta(model=CustodyArrangements.class)
public class CustodyArrangementsMeta implements RosettaMetaData<CustodyArrangements> {

	@Override
	public List<Validator<? super CustodyArrangements>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CustodyArrangements>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodyArrangements, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodyArrangements> validator() {
		return new cdm.legalagreement.csa.validation.CustodyArrangementsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodyArrangements, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CustodyArrangementsOnlyExistsValidator();
	}
}

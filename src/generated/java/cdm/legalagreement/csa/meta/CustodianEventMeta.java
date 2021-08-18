package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CustodianEvent;
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
@RosettaMeta(model=CustodianEvent.class)
public class CustodianEventMeta implements RosettaMetaData<CustodianEvent> {

	@Override
	public List<Validator<? super CustodianEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CustodianEvent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianEvent> validator() {
		return new cdm.legalagreement.csa.validation.CustodianEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianEvent, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CustodianEventOnlyExistsValidator();
	}
}

package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CustodianEventEndDate;
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
@RosettaMeta(model=CustodianEventEndDate.class)
public class CustodianEventEndDateMeta implements RosettaMetaData<CustodianEventEndDate> {

	@Override
	public List<Validator<? super CustodianEventEndDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CustodianEventEndDate>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CustodianEventEndDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CustodianEventEndDate> validator() {
		return new cdm.legalagreement.csa.validation.CustodianEventEndDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CustodianEventEndDate, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CustodianEventEndDateOnlyExistsValidator();
	}
}

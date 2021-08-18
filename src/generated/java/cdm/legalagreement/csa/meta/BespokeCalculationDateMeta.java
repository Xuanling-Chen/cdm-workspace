package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.BespokeCalculationDate;
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
@RosettaMeta(model=BespokeCalculationDate.class)
public class BespokeCalculationDateMeta implements RosettaMetaData<BespokeCalculationDate> {

	@Override
	public List<Validator<? super BespokeCalculationDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.BespokeCalculationDateCalculationDateImTerms.class)
		);
	}

	@Override
	public List<Validator<? super BespokeCalculationDate>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BespokeCalculationDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BespokeCalculationDate> validator() {
		return new cdm.legalagreement.csa.validation.BespokeCalculationDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BespokeCalculationDate, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.BespokeCalculationDateOnlyExistsValidator();
	}
}

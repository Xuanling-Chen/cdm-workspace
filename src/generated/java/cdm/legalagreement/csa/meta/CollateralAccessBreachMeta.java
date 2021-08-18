package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CollateralAccessBreach;
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
@RosettaMeta(model=CollateralAccessBreach.class)
public class CollateralAccessBreachMeta implements RosettaMetaData<CollateralAccessBreach> {

	@Override
	public List<Validator<? super CollateralAccessBreach>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.CollateralAccessBreachCabEndDateTerms.class)
		);
	}

	@Override
	public List<Validator<? super CollateralAccessBreach>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralAccessBreach, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralAccessBreach> validator() {
		return new cdm.legalagreement.csa.validation.CollateralAccessBreachValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralAccessBreach, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CollateralAccessBreachOnlyExistsValidator();
	}
}

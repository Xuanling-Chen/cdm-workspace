package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CollateralValuationTreatment;
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
@RosettaMeta(model=CollateralValuationTreatment.class)
public class CollateralValuationTreatmentMeta implements RosettaMetaData<CollateralValuationTreatment> {

	@Override
	public List<Validator<? super CollateralValuationTreatment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.CollateralValuationTreatmentHaircutPercentage.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.CollateralValuationTreatmentMarginPercentage.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.CollateralValuationTreatmentFxHaircutPercentage.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.CollateralValuationTreatmentAdditionalHaircutPercentage.class)
		);
	}

	@Override
	public List<Validator<? super CollateralValuationTreatment>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.CollateralValuationTreatmentHaircutPercentageOrMarginPercentage()
		);
	}
	
	@Override
	public List<Function<? super CollateralValuationTreatment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralValuationTreatment> validator() {
		return new cdm.legalagreement.csa.validation.CollateralValuationTreatmentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralValuationTreatment, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CollateralValuationTreatmentOnlyExistsValidator();
	}
}

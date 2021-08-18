package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.EligibleCollateralSchedule;
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
@RosettaMeta(model=EligibleCollateralSchedule.class)
public class EligibleCollateralScheduleMeta implements RosettaMetaData<EligibleCollateralSchedule> {

	@Override
	public List<Validator<? super EligibleCollateralSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super EligibleCollateralSchedule>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EligibleCollateralSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EligibleCollateralSchedule> validator() {
		return new cdm.legalagreement.csa.validation.EligibleCollateralScheduleValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EligibleCollateralSchedule, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.EligibleCollateralScheduleOnlyExistsValidator();
	}
}

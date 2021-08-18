package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AmendmentEffectiveDate;
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
@RosettaMeta(model=AmendmentEffectiveDate.class)
public class AmendmentEffectiveDateMeta implements RosettaMetaData<AmendmentEffectiveDate> {

	@Override
	public List<Validator<? super AmendmentEffectiveDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AmendmentEffectiveDate>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.AmendmentEffectiveDateOneOf0()
		);
	}
	
	@Override
	public List<Function<? super AmendmentEffectiveDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AmendmentEffectiveDate> validator() {
		return new cdm.legalagreement.csa.validation.AmendmentEffectiveDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AmendmentEffectiveDate, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AmendmentEffectiveDateOnlyExistsValidator();
	}
}

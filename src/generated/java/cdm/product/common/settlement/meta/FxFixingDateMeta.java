package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.FxFixingDate;
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
@RosettaMeta(model=FxFixingDate.class)
public class FxFixingDateMeta implements RosettaMetaData<FxFixingDate> {

	@Override
	public List<Validator<? super FxFixingDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super FxFixingDate>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.settlement.validation.choicerule.FxFixingDateBusinessCentersChoice(),
			new cdm.product.common.settlement.validation.choicerule.FxFixingDateDateChoice()
		);
	}
	
	@Override
	public List<Function<? super FxFixingDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFixingDate> validator() {
		return new cdm.product.common.settlement.validation.FxFixingDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingDate, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.FxFixingDateOnlyExistsValidator();
	}
}

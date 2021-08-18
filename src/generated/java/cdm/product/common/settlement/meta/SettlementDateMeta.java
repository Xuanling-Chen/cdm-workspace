package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.SettlementDate;
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
@RosettaMeta(model=SettlementDate.class)
public class SettlementDateMeta implements RosettaMetaData<SettlementDate> {

	@Override
	public List<Validator<? super SettlementDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.settlement.validation.datarule.SettlementDateBusinessDays.class)
		);
	}

	@Override
	public List<Validator<? super SettlementDate>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.settlement.validation.choicerule.SettlementDateDateChoice()
		);
	}
	
	@Override
	public List<Function<? super SettlementDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementDate> validator() {
		return new cdm.product.common.settlement.validation.SettlementDateValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementDate, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.SettlementDateOnlyExistsValidator();
	}
}

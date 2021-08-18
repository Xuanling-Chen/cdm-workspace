package cdm.event.common.meta;

import cdm.event.common.CashTransferComponent;
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
@RosettaMeta(model=CashTransferComponent.class)
public class CashTransferComponentMeta implements RosettaMetaData<CashTransferComponent> {

	@Override
	public List<Validator<? super CashTransferComponent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CashTransferComponent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashTransferComponent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashTransferComponent> validator() {
		return new cdm.event.common.validation.CashTransferComponentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashTransferComponent, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.CashTransferComponentOnlyExistsValidator();
	}
}

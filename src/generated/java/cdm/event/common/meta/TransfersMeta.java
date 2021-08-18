package cdm.event.common.meta;

import cdm.event.common.Transfers;
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
@RosettaMeta(model=Transfers.class)
public class TransfersMeta implements RosettaMetaData<Transfers> {

	@Override
	public List<Validator<? super Transfers>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Transfers>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Transfers, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Transfers> validator() {
		return new cdm.event.common.validation.TransfersValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Transfers, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.TransfersOnlyExistsValidator();
	}
}

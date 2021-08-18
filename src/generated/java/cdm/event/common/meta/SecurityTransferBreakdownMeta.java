package cdm.event.common.meta;

import cdm.event.common.SecurityTransferBreakdown;
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
@RosettaMeta(model=SecurityTransferBreakdown.class)
public class SecurityTransferBreakdownMeta implements RosettaMetaData<SecurityTransferBreakdown> {

	@Override
	public List<Validator<? super SecurityTransferBreakdown>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SecurityTransferBreakdown>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityTransferBreakdown, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityTransferBreakdown> validator() {
		return new cdm.event.common.validation.SecurityTransferBreakdownValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityTransferBreakdown, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.SecurityTransferBreakdownOnlyExistsValidator();
	}
}

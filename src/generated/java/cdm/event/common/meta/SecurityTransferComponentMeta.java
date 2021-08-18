package cdm.event.common.meta;

import cdm.event.common.SecurityTransferComponent;
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
@RosettaMeta(model=SecurityTransferComponent.class)
public class SecurityTransferComponentMeta implements RosettaMetaData<SecurityTransferComponent> {

	@Override
	public List<Validator<? super SecurityTransferComponent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SecurityTransferComponent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityTransferComponent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityTransferComponent> validator() {
		return new cdm.event.common.validation.SecurityTransferComponentValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityTransferComponent, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.SecurityTransferComponentOnlyExistsValidator();
	}
}

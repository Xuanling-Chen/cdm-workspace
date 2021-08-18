package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.PostedCreditSupportItem;
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
@RosettaMeta(model=PostedCreditSupportItem.class)
public class PostedCreditSupportItemMeta implements RosettaMetaData<PostedCreditSupportItem> {

	@Override
	public List<Validator<? super PostedCreditSupportItem>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PostedCreditSupportItem>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PostedCreditSupportItem, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PostedCreditSupportItem> validator() {
		return new cdm.legalagreement.csa.validation.PostedCreditSupportItemValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PostedCreditSupportItem, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.PostedCreditSupportItemOnlyExistsValidator();
	}
}

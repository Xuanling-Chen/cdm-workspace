package cdm.product.template.meta;

import cdm.product.template.Knock;
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
@RosettaMeta(model=Knock.class)
public class KnockMeta implements RosettaMetaData<Knock> {

	@Override
	public List<Validator<? super Knock>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Knock>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Knock, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Knock> validator() {
		return new cdm.product.template.validation.KnockValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Knock, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.KnockOnlyExistsValidator();
	}
}

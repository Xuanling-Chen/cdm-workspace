package cdm.product.template.meta;

import cdm.product.template.Asian;
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
@RosettaMeta(model=Asian.class)
public class AsianMeta implements RosettaMetaData<Asian> {

	@Override
	public List<Validator<? super Asian>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Asian>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Asian, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Asian> validator() {
		return new cdm.product.template.validation.AsianValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Asian, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.AsianOnlyExistsValidator();
	}
}

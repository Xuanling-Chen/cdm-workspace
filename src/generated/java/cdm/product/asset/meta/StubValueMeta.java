package cdm.product.asset.meta;

import cdm.product.asset.StubValue;
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
@RosettaMeta(model=StubValue.class)
public class StubValueMeta implements RosettaMetaData<StubValue> {

	@Override
	public List<Validator<? super StubValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super StubValue>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.asset.validation.choicerule.StubValueOneOf0()
		);
	}
	
	@Override
	public List<Function<? super StubValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super StubValue> validator() {
		return new cdm.product.asset.validation.StubValueValidator();
	}
	
	@Override
	public ValidatorWithArg<? super StubValue, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.StubValueOnlyExistsValidator();
	}
}

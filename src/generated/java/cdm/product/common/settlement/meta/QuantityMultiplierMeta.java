package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.QuantityMultiplier;
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
@RosettaMeta(model=QuantityMultiplier.class)
public class QuantityMultiplierMeta implements RosettaMetaData<QuantityMultiplier> {

	@Override
	public List<Validator<? super QuantityMultiplier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super QuantityMultiplier>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.settlement.validation.choicerule.QuantityMultiplierOneOf0()
		);
	}
	
	@Override
	public List<Function<? super QuantityMultiplier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super QuantityMultiplier> validator() {
		return new cdm.product.common.settlement.validation.QuantityMultiplierValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuantityMultiplier, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.QuantityMultiplierOnlyExistsValidator();
	}
}

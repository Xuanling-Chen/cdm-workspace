package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.ResolvablePayoutQuantity;
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
@RosettaMeta(model=ResolvablePayoutQuantity.class)
public class ResolvablePayoutQuantityMeta implements RosettaMetaData<ResolvablePayoutQuantity> {

	@Override
	public List<Validator<? super ResolvablePayoutQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.settlement.validation.datarule.ResolvablePayoutQuantityQuantityMultiplier.class)
		);
	}

	@Override
	public List<Validator<? super ResolvablePayoutQuantity>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.settlement.validation.choicerule.ResolvablePayoutQuantityResolvablePayoutQuantityChoice()
		);
	}
	
	@Override
	public List<Function<? super ResolvablePayoutQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ResolvablePayoutQuantity> validator() {
		return new cdm.product.common.settlement.validation.ResolvablePayoutQuantityValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ResolvablePayoutQuantity, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.ResolvablePayoutQuantityOnlyExistsValidator();
	}
}

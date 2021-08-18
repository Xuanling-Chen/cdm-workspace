package cdm.observable.asset.meta;

import cdm.observable.asset.PriceQuantity;
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
@RosettaMeta(model=PriceQuantity.class)
public class PriceQuantityMeta implements RosettaMetaData<PriceQuantity> {

	@Override
	public List<Validator<? super PriceQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.observable.asset.validation.datarule.PriceQuantityNonNegativeQuantity.class),
			factory.create(cdm.observable.asset.validation.datarule.PriceQuantityDataRule0.class)
		);
	}

	@Override
	public List<Validator<? super PriceQuantity>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceQuantity> validator() {
		return new cdm.observable.asset.validation.PriceQuantityValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceQuantity, Set<String>> onlyExistsValidator() {
		return new cdm.observable.asset.validation.exists.PriceQuantityOnlyExistsValidator();
	}
}

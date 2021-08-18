package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.CollateralTaxonomyValue;
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
@RosettaMeta(model=CollateralTaxonomyValue.class)
public class CollateralTaxonomyValueMeta implements RosettaMetaData<CollateralTaxonomyValue> {

	@Override
	public List<Validator<? super CollateralTaxonomyValue>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CollateralTaxonomyValue>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.staticdata.asset.common.validation.choicerule.CollateralTaxonomyValueOneOf0()
		);
	}
	
	@Override
	public List<Function<? super CollateralTaxonomyValue, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralTaxonomyValue> validator() {
		return new cdm.base.staticdata.asset.common.validation.CollateralTaxonomyValueValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralTaxonomyValue, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.common.validation.exists.CollateralTaxonomyValueOnlyExistsValidator();
	}
}

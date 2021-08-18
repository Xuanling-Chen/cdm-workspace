package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.CommodityReferenceFramework;
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
@RosettaMeta(model=CommodityReferenceFramework.class)
public class CommodityReferenceFrameworkMeta implements RosettaMetaData<CommodityReferenceFramework> {

	@Override
	public List<Validator<? super CommodityReferenceFramework>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CommodityReferenceFramework>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.staticdata.asset.common.validation.choicerule.CommodityReferenceFrameworkCommodityReferenceFrameworkChoice()
		);
	}
	
	@Override
	public List<Function<? super CommodityReferenceFramework, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityReferenceFramework> validator() {
		return new cdm.base.staticdata.asset.common.validation.CommodityReferenceFrameworkValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityReferenceFramework, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.common.validation.exists.CommodityReferenceFrameworkOnlyExistsValidator();
	}
}

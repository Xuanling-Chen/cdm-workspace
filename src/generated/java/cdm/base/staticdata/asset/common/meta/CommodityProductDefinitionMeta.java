package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.CommodityProductDefinition;
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
@RosettaMeta(model=CommodityProductDefinition.class)
public class CommodityProductDefinitionMeta implements RosettaMetaData<CommodityProductDefinition> {

	@Override
	public List<Validator<? super CommodityProductDefinition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CommodityProductDefinition>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.staticdata.asset.common.validation.choicerule.CommodityProductDefinitionCommodityProductDefinitionChoice()
		);
	}
	
	@Override
	public List<Function<? super CommodityProductDefinition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityProductDefinition> validator() {
		return new cdm.base.staticdata.asset.common.validation.CommodityProductDefinitionValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityProductDefinition, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.common.validation.exists.CommodityProductDefinitionOnlyExistsValidator();
	}
}

package cdm.event.common.meta;

import cdm.event.common.CommodityTransferBreakdown;
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
@RosettaMeta(model=CommodityTransferBreakdown.class)
public class CommodityTransferBreakdownMeta implements RosettaMetaData<CommodityTransferBreakdown> {

	@Override
	public List<Validator<? super CommodityTransferBreakdown>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CommodityTransferBreakdown>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityTransferBreakdown, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityTransferBreakdown> validator() {
		return new cdm.event.common.validation.CommodityTransferBreakdownValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityTransferBreakdown, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.CommodityTransferBreakdownOnlyExistsValidator();
	}
}

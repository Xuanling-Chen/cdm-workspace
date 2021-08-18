package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AssetCriteria;
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
@RosettaMeta(model=AssetCriteria.class)
public class AssetCriteriaMeta implements RosettaMetaData<AssetCriteria> {

	@Override
	public List<Validator<? super AssetCriteria>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AssetCriteria>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.legalagreement.csa.validation.choicerule.AssetCriteriaAssetCriteriaChoice()
		);
	}
	
	@Override
	public List<Function<? super AssetCriteria, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AssetCriteria> validator() {
		return new cdm.legalagreement.csa.validation.AssetCriteriaValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AssetCriteria, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AssetCriteriaOnlyExistsValidator();
	}
}

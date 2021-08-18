package cdm.product.asset.meta;

import cdm.product.asset.ReferenceObligation;
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
@RosettaMeta(model=ReferenceObligation.class)
public class ReferenceObligationMeta implements RosettaMetaData<ReferenceObligation> {

	@Override
	public List<Validator<? super ReferenceObligation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ReferenceObligation>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.asset.validation.choicerule.ReferenceObligationAssetChoice(),
			new cdm.product.asset.validation.choicerule.ReferenceObligationLegalEntityChoice()
		);
	}
	
	@Override
	public List<Function<? super ReferenceObligation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferenceObligation> validator() {
		return new cdm.product.asset.validation.ReferenceObligationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceObligation, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.ReferenceObligationOnlyExistsValidator();
	}
}

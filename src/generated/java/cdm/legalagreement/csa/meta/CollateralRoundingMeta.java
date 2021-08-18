package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.CollateralRounding;
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
@RosettaMeta(model=CollateralRounding.class)
public class CollateralRoundingMeta implements RosettaMetaData<CollateralRounding> {

	@Override
	public List<Validator<? super CollateralRounding>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CollateralRounding>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralRounding, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralRounding> validator() {
		return new cdm.legalagreement.csa.validation.CollateralRoundingValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralRounding, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.CollateralRoundingOnlyExistsValidator();
	}
}

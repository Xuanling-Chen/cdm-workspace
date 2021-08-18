package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.Regime;
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
@RosettaMeta(model=Regime.class)
public class RegimeMeta implements RosettaMetaData<Regime> {

	@Override
	public List<Validator<? super Regime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Regime>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Regime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Regime> validator() {
		return new cdm.legalagreement.csa.validation.RegimeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Regime, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.RegimeOnlyExistsValidator();
	}
}

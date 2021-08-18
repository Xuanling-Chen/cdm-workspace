package cdm.product.template.meta;

import cdm.product.template.SecurityFinanceLeg;
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
@RosettaMeta(model=SecurityFinanceLeg.class)
public class SecurityFinanceLegMeta implements RosettaMetaData<SecurityFinanceLeg> {

	@Override
	public List<Validator<? super SecurityFinanceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SecurityFinanceLeg>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SecurityFinanceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SecurityFinanceLeg> validator() {
		return new cdm.product.template.validation.SecurityFinanceLegValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SecurityFinanceLeg, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.SecurityFinanceLegOnlyExistsValidator();
	}
}

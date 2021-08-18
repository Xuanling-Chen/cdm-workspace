package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.Security;
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
@RosettaMeta(model=Security.class)
public class SecurityMeta implements RosettaMetaData<Security> {

	@Override
	public List<Validator<? super Security>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.base.staticdata.asset.common.validation.datarule.SecurityDebtSubType.class),
			factory.create(cdm.base.staticdata.asset.common.validation.datarule.SecurityEquitySubType.class),
			factory.create(cdm.base.staticdata.asset.common.validation.datarule.SecurityFundSubType.class)
		);
	}

	@Override
	public List<Validator<? super Security>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Security, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Security> validator() {
		return new cdm.base.staticdata.asset.common.validation.SecurityValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Security, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.common.validation.exists.SecurityOnlyExistsValidator();
	}
}

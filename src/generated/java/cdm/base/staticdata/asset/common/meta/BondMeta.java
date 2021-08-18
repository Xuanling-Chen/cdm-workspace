package cdm.base.staticdata.asset.common.meta;

import cdm.base.staticdata.asset.common.Bond;
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
@RosettaMeta(model=Bond.class)
public class BondMeta implements RosettaMetaData<Bond> {

	@Override
	public List<Validator<? super Bond>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Bond>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Bond, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Bond> validator() {
		return new cdm.base.staticdata.asset.common.validation.BondValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Bond, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.common.validation.exists.BondOnlyExistsValidator();
	}
}

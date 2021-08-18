package cdm.base.staticdata.asset.credit.meta;

import cdm.base.staticdata.asset.credit.Obligations;
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
@RosettaMeta(model=Obligations.class)
public class ObligationsMeta implements RosettaMetaData<Obligations> {

	@Override
	public List<Validator<? super Obligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Obligations>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.staticdata.asset.credit.validation.choicerule.ObligationsObligationsChoice()
		);
	}
	
	@Override
	public List<Function<? super Obligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Obligations> validator() {
		return new cdm.base.staticdata.asset.credit.validation.ObligationsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Obligations, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.asset.credit.validation.exists.ObligationsOnlyExistsValidator();
	}
}

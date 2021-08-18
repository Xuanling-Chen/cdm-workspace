package cdm.base.staticdata.party.meta;

import cdm.base.staticdata.party.Party;
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
@RosettaMeta(model=Party.class)
public class PartyMeta implements RosettaMetaData<Party> {

	@Override
	public List<Validator<? super Party>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Party>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Party, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Party> validator() {
		return new cdm.base.staticdata.party.validation.PartyValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Party, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.party.validation.exists.PartyOnlyExistsValidator();
	}
}

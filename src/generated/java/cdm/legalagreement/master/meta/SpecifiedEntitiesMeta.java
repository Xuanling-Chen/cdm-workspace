package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.SpecifiedEntities;
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
@RosettaMeta(model=SpecifiedEntities.class)
public class SpecifiedEntitiesMeta implements RosettaMetaData<SpecifiedEntities> {

	@Override
	public List<Validator<? super SpecifiedEntities>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super SpecifiedEntities>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpecifiedEntities, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpecifiedEntities> validator() {
		return new cdm.legalagreement.master.validation.SpecifiedEntitiesValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecifiedEntities, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.SpecifiedEntitiesOnlyExistsValidator();
	}
}

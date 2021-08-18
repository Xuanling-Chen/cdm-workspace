package cdm.observable.event.meta;

import cdm.observable.event.Representations;
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
@RosettaMeta(model=Representations.class)
public class RepresentationsMeta implements RosettaMetaData<Representations> {

	@Override
	public List<Validator<? super Representations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Representations>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Representations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Representations> validator() {
		return new cdm.observable.event.validation.RepresentationsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Representations, Set<String>> onlyExistsValidator() {
		return new cdm.observable.event.validation.exists.RepresentationsOnlyExistsValidator();
	}
}

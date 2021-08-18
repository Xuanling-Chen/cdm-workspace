package cdm.base.staticdata.party.meta;

import cdm.base.staticdata.party.AncillaryEntity;
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
@RosettaMeta(model=AncillaryEntity.class)
public class AncillaryEntityMeta implements RosettaMetaData<AncillaryEntity> {

	@Override
	public List<Validator<? super AncillaryEntity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super AncillaryEntity>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.staticdata.party.validation.choicerule.AncillaryEntityOneOf0()
		);
	}
	
	@Override
	public List<Function<? super AncillaryEntity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AncillaryEntity> validator() {
		return new cdm.base.staticdata.party.validation.AncillaryEntityValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AncillaryEntity, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.party.validation.exists.AncillaryEntityOnlyExistsValidator();
	}
}

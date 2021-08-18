package cdm.legalagreement.master.meta;

import cdm.legalagreement.master.SpecifiedEntity;
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
@RosettaMeta(model=SpecifiedEntity.class)
public class SpecifiedEntityMeta implements RosettaMetaData<SpecifiedEntity> {

	@Override
	public List<Validator<? super SpecifiedEntity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.master.validation.datarule.SpecifiedEntitySpecifiedEntity.class),
			factory.create(cdm.legalagreement.master.validation.datarule.SpecifiedEntityMaterialSubsidiary.class),
			factory.create(cdm.legalagreement.master.validation.datarule.SpecifiedEntityOtherSpecifiedEntity.class)
		);
	}

	@Override
	public List<Validator<? super SpecifiedEntity>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpecifiedEntity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpecifiedEntity> validator() {
		return new cdm.legalagreement.master.validation.SpecifiedEntityValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecifiedEntity, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.master.validation.exists.SpecifiedEntityOnlyExistsValidator();
	}
}

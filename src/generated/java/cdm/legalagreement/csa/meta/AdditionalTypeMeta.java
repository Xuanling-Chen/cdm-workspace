package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.AdditionalType;
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
@RosettaMeta(model=AdditionalType.class)
public class AdditionalTypeMeta implements RosettaMetaData<AdditionalType> {

	@Override
	public List<Validator<? super AdditionalType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.legalagreement.csa.validation.datarule.AdditionalTypeCustomValue.class),
			factory.create(cdm.legalagreement.csa.validation.datarule.AdditionalTypeStandardValue.class)
		);
	}

	@Override
	public List<Validator<? super AdditionalType>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AdditionalType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AdditionalType> validator() {
		return new cdm.legalagreement.csa.validation.AdditionalTypeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdditionalType, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.AdditionalTypeOnlyExistsValidator();
	}
}

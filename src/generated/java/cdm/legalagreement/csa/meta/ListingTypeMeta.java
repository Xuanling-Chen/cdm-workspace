package cdm.legalagreement.csa.meta;

import cdm.legalagreement.csa.ListingType;
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
@RosettaMeta(model=ListingType.class)
public class ListingTypeMeta implements RosettaMetaData<ListingType> {

	@Override
	public List<Validator<? super ListingType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ListingType>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ListingType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ListingType> validator() {
		return new cdm.legalagreement.csa.validation.ListingTypeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ListingType, Set<String>> onlyExistsValidator() {
		return new cdm.legalagreement.csa.validation.exists.ListingTypeOnlyExistsValidator();
	}
}

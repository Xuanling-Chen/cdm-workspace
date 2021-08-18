package cdm.product.asset.meta;

import cdm.product.asset.GeneralTerms;
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
@RosettaMeta(model=GeneralTerms.class)
public class GeneralTermsMeta implements RosettaMetaData<GeneralTerms> {

	@Override
	public List<Validator<? super GeneralTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.asset.validation.datarule.GeneralTermsFpMLCd41.class),
			factory.create(cdm.product.asset.validation.datarule.GeneralTermsFpMLCd42.class),
			factory.create(cdm.product.asset.validation.datarule.GeneralTermsBasketReferenceInformationNameOrId.class)
		);
	}

	@Override
	public List<Validator<? super GeneralTerms>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.asset.validation.choicerule.GeneralTermsGeneralTermsChoice()
		);
	}
	
	@Override
	public List<Function<? super GeneralTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super GeneralTerms> validator() {
		return new cdm.product.asset.validation.GeneralTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GeneralTerms, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.GeneralTermsOnlyExistsValidator();
	}
}

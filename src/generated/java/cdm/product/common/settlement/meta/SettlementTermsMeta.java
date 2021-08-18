package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.SettlementTerms;
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
@RosettaMeta(model=SettlementTerms.class)
public class SettlementTermsMeta implements RosettaMetaData<SettlementTerms> {

	@Override
	public List<Validator<? super SettlementTerms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.settlement.validation.datarule.SettlementTermsCashSettlementTerms.class),
			factory.create(cdm.product.common.settlement.validation.datarule.SettlementTermsPhysicalSettlementTerms.class)
		);
	}

	@Override
	public List<Validator<? super SettlementTerms>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.settlement.validation.choicerule.SettlementTermsOptionSettlementChoice()
		);
	}
	
	@Override
	public List<Function<? super SettlementTerms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementTerms> validator() {
		return new cdm.product.common.settlement.validation.SettlementTermsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementTerms, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.SettlementTermsOnlyExistsValidator();
	}
}

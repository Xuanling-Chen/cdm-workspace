package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.DeliverableObligations;
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
@RosettaMeta(model=DeliverableObligations.class)
public class DeliverableObligationsMeta implements RosettaMetaData<DeliverableObligations> {

	@Override
	public List<Validator<? super DeliverableObligations>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.common.settlement.validation.datarule.DeliverableObligationsFpMLCd34.class)
		);
	}

	@Override
	public List<Validator<? super DeliverableObligations>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.product.common.settlement.validation.choicerule.DeliverableObligationsDeliverableObligationsChoice()
		);
	}
	
	@Override
	public List<Function<? super DeliverableObligations, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeliverableObligations> validator() {
		return new cdm.product.common.settlement.validation.DeliverableObligationsValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeliverableObligations, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.DeliverableObligationsOnlyExistsValidator();
	}
}

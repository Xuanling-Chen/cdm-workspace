package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.PCDeliverableObligationCharac;
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
@RosettaMeta(model=PCDeliverableObligationCharac.class)
public class PCDeliverableObligationCharacMeta implements RosettaMetaData<PCDeliverableObligationCharac> {

	@Override
	public List<Validator<? super PCDeliverableObligationCharac>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super PCDeliverableObligationCharac>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PCDeliverableObligationCharac, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PCDeliverableObligationCharac> validator() {
		return new cdm.product.common.settlement.validation.PCDeliverableObligationCharacValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PCDeliverableObligationCharac, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.PCDeliverableObligationCharacOnlyExistsValidator();
	}
}

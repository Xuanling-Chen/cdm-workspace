package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.LoanParticipation;
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
@RosettaMeta(model=LoanParticipation.class)
public class LoanParticipationMeta implements RosettaMetaData<LoanParticipation> {

	@Override
	public List<Validator<? super LoanParticipation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super LoanParticipation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super LoanParticipation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LoanParticipation> validator() {
		return new cdm.product.common.settlement.validation.LoanParticipationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LoanParticipation, Set<String>> onlyExistsValidator() {
		return new cdm.product.common.settlement.validation.exists.LoanParticipationOnlyExistsValidator();
	}
}

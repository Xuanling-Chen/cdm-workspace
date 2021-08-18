package cdm.product.asset.meta;

import cdm.product.asset.CashflowRepresentation;
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
@RosettaMeta(model=CashflowRepresentation.class)
public class CashflowRepresentationMeta implements RosettaMetaData<CashflowRepresentation> {

	@Override
	public List<Validator<? super CashflowRepresentation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super CashflowRepresentation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashflowRepresentation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashflowRepresentation> validator() {
		return new cdm.product.asset.validation.CashflowRepresentationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashflowRepresentation, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.CashflowRepresentationOnlyExistsValidator();
	}
}

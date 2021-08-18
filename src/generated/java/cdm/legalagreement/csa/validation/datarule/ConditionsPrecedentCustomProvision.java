package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.ConditionsPrecedent;
import cdm.legalagreement.csa.ExceptionEnum;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ConditionsPrecedentCustomProvision")
public class ConditionsPrecedentCustomProvision implements Validator<ConditionsPrecedent> {
	
	private static final String NAME = "ConditionsPrecedentCustomProvision";
	private static final String DEFINITION = "if customProvision exists then conditionsPrecedentElection = ExceptionEnum->Other";
	
	
	@Override
	public ValidationResult<ConditionsPrecedent> validate(RosettaPath path, ConditionsPrecedent conditionsPrecedent) {
		ComparisonResult result = executeDataRule(conditionsPrecedent);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ConditionsPrecedent", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ConditionsPrecedent", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ConditionsPrecedent conditionsPrecedent) {
		if (ruleIsApplicable(conditionsPrecedent).get()) {
			return evaluateThenExpression(conditionsPrecedent);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ConditionsPrecedent conditionsPrecedent) {
		try {
			return exists(MapperS.of(conditionsPrecedent).<String>map("getCustomProvision", _conditionsPrecedent -> _conditionsPrecedent.getCustomProvision()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ConditionsPrecedent conditionsPrecedent) {
		try {
			return areEqual(MapperS.of(conditionsPrecedent).<ExceptionEnum>map("getConditionsPrecedentElection", _conditionsPrecedent -> _conditionsPrecedent.getConditionsPrecedentElection()), MapperS.of(ExceptionEnum.OTHER), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

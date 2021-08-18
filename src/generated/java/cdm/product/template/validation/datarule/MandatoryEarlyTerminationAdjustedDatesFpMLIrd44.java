package cdm.product.template.validation.datarule;

import cdm.product.template.MandatoryEarlyTerminationAdjustedDates;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("MandatoryEarlyTerminationAdjustedDatesFpML_ird_44")
public class MandatoryEarlyTerminationAdjustedDatesFpMLIrd44 implements Validator<MandatoryEarlyTerminationAdjustedDates> {
	
	private static final String NAME = "MandatoryEarlyTerminationAdjustedDatesFpML_ird_44";
	private static final String DEFINITION = "if MandatoryEarlyTerminationAdjustedDates exists then adjustedEarlyTerminationDate <= adjustedCashSettlementValuationDate and adjustedCashSettlementValuationDate <= adjustedCashSettlementPaymentDate";
	
	
	@Override
	public ValidationResult<MandatoryEarlyTerminationAdjustedDates> validate(RosettaPath path, MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates) {
		ComparisonResult result = executeDataRule(mandatoryEarlyTerminationAdjustedDates);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "MandatoryEarlyTerminationAdjustedDates", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MandatoryEarlyTerminationAdjustedDates", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates) {
		if (ruleIsApplicable(mandatoryEarlyTerminationAdjustedDates).get()) {
			return evaluateThenExpression(mandatoryEarlyTerminationAdjustedDates);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates) {
		try {
			return exists(MapperS.of(mandatoryEarlyTerminationAdjustedDates));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(MandatoryEarlyTerminationAdjustedDates mandatoryEarlyTerminationAdjustedDates) {
		try {
			return lessThanEquals(MapperS.of(mandatoryEarlyTerminationAdjustedDates).<Date>map("getAdjustedEarlyTerminationDate", _mandatoryEarlyTerminationAdjustedDates -> _mandatoryEarlyTerminationAdjustedDates.getAdjustedEarlyTerminationDate()), MapperS.of(mandatoryEarlyTerminationAdjustedDates).<Date>map("getAdjustedCashSettlementValuationDate", _mandatoryEarlyTerminationAdjustedDates -> _mandatoryEarlyTerminationAdjustedDates.getAdjustedCashSettlementValuationDate()), CardinalityOperator.All).and(lessThanEquals(MapperS.of(mandatoryEarlyTerminationAdjustedDates).<Date>map("getAdjustedCashSettlementValuationDate", _mandatoryEarlyTerminationAdjustedDates -> _mandatoryEarlyTerminationAdjustedDates.getAdjustedCashSettlementValuationDate()), MapperS.of(mandatoryEarlyTerminationAdjustedDates).<Date>map("getAdjustedCashSettlementPaymentDate", _mandatoryEarlyTerminationAdjustedDates -> _mandatoryEarlyTerminationAdjustedDates.getAdjustedCashSettlementPaymentDate()), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

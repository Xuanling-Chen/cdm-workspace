package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
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
@RosettaDataRule("PhysicalSettlementPeriodBusinessDays")
public class PhysicalSettlementPeriodBusinessDays implements Validator<PhysicalSettlementPeriod> {
	
	private static final String NAME = "PhysicalSettlementPeriodBusinessDays";
	private static final String DEFINITION = "if businessDays exists then businessDays >= 0";
	
	
	@Override
	public ValidationResult<PhysicalSettlementPeriod> validate(RosettaPath path, PhysicalSettlementPeriod physicalSettlementPeriod) {
		ComparisonResult result = executeDataRule(physicalSettlementPeriod);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PhysicalSettlementPeriod", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlementPeriod", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PhysicalSettlementPeriod physicalSettlementPeriod) {
		if (ruleIsApplicable(physicalSettlementPeriod).get()) {
			return evaluateThenExpression(physicalSettlementPeriod);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PhysicalSettlementPeriod physicalSettlementPeriod) {
		try {
			return exists(MapperS.of(physicalSettlementPeriod).<Integer>map("getBusinessDays", _physicalSettlementPeriod -> _physicalSettlementPeriod.getBusinessDays()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PhysicalSettlementPeriod physicalSettlementPeriod) {
		try {
			return greaterThanEquals(MapperS.of(physicalSettlementPeriod).<Integer>map("getBusinessDays", _physicalSettlementPeriod -> _physicalSettlementPeriod.getBusinessDays()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

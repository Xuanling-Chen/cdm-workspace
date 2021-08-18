package cdm.base.math.validation.datarule;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.Quantity;
import cdm.base.math.metafields.ReferenceWithMetaQuantity;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("NonNegativeQuantityScheduleNonNegativeQuantity_amount")
public class NonNegativeQuantityScheduleNonNegativeQuantityAmount implements Validator<NonNegativeQuantitySchedule> {
	
	private static final String NAME = "NonNegativeQuantityScheduleNonNegativeQuantity_amount";
	private static final String DEFINITION = "if initialQuantity exists then initialQuantity->amount >= 0.0";
	
	
	@Override
	public ValidationResult<NonNegativeQuantitySchedule> validate(RosettaPath path, NonNegativeQuantitySchedule nonNegativeQuantitySchedule) {
		ComparisonResult result = executeDataRule(nonNegativeQuantitySchedule);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "NonNegativeQuantitySchedule", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "NonNegativeQuantitySchedule", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(NonNegativeQuantitySchedule nonNegativeQuantitySchedule) {
		if (ruleIsApplicable(nonNegativeQuantitySchedule).get()) {
			return evaluateThenExpression(nonNegativeQuantitySchedule);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(NonNegativeQuantitySchedule nonNegativeQuantitySchedule) {
		try {
			return exists(MapperS.of(nonNegativeQuantitySchedule).<ReferenceWithMetaQuantity>map("getInitialQuantity", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getInitialQuantity()).<Quantity>map("getValue", _f->_f.getValue()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(NonNegativeQuantitySchedule nonNegativeQuantitySchedule) {
		try {
			return greaterThanEquals(MapperS.of(nonNegativeQuantitySchedule).<ReferenceWithMetaQuantity>map("getInitialQuantity", _nonNegativeQuantitySchedule -> _nonNegativeQuantitySchedule.getInitialQuantity()).<Quantity>map("getValue", _f->_f.getValue()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(BigDecimal.valueOf(0.0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

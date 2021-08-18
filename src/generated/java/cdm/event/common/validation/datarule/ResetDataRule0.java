package cdm.event.common.validation.datarule;

import cdm.event.common.AggregationMethod;
import cdm.event.common.Reset;
import cdm.observable.event.Observation;
import cdm.observable.event.metafields.ReferenceWithMetaObservation;
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
@RosettaDataRule("ResetDataRule0")
public class ResetDataRule0 implements Validator<Reset> {
	
	private static final String NAME = "ResetDataRule0";
	private static final String DEFINITION = "if observations count > 1 then aggregationMethodology exists";
	
	
	@Override
	public ValidationResult<Reset> validate(RosettaPath path, Reset reset) {
		ComparisonResult result = executeDataRule(reset);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Reset", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Reset", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Reset reset) {
		if (ruleIsApplicable(reset).get()) {
			return evaluateThenExpression(reset);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Reset reset) {
		try {
			return greaterThan(MapperS.of(MapperS.of(reset).<ReferenceWithMetaObservation>mapC("getObservations", _reset -> _reset.getObservations()).<Observation>map("getValue", _f->_f.getValue()).resultCount()), MapperS.of(Integer.valueOf(1)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Reset reset) {
		try {
			return exists(MapperS.of(reset).<AggregationMethod>map("getAggregationMethodology", _reset -> _reset.getAggregationMethodology()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CrossRate;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("CrossRateCrossRate")
public class CrossRateCrossRate implements Validator<CrossRate> {
	
	private static final String NAME = "CrossRateCrossRate";
	private static final String DEFINITION = "if forwardPoints exists then spotRate exists";
	
	
	@Override
	public ValidationResult<CrossRate> validate(RosettaPath path, CrossRate crossRate) {
		ComparisonResult result = executeDataRule(crossRate);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "CrossRate", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "CrossRate", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(CrossRate crossRate) {
		if (ruleIsApplicable(crossRate).get()) {
			return evaluateThenExpression(crossRate);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(CrossRate crossRate) {
		try {
			return exists(MapperS.of(crossRate).<BigDecimal>map("getForwardPoints", _crossRate -> _crossRate.getForwardPoints()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(CrossRate crossRate) {
		try {
			return exists(MapperS.of(crossRate).<BigDecimal>map("getSpotRate", _crossRate -> _crossRate.getSpotRate()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

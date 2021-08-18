package cdm.observable.event.validation.datarule;

import cdm.observable.event.PubliclyAvailableInformation;
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
@RosettaDataRule("PubliclyAvailableInformationPositiveSpecifiedNumber")
public class PubliclyAvailableInformationPositiveSpecifiedNumber implements Validator<PubliclyAvailableInformation> {
	
	private static final String NAME = "PubliclyAvailableInformationPositiveSpecifiedNumber";
	private static final String DEFINITION = "if specifiedNumber exists then specifiedNumber >= 0";
	
	
	@Override
	public ValidationResult<PubliclyAvailableInformation> validate(RosettaPath path, PubliclyAvailableInformation publiclyAvailableInformation) {
		ComparisonResult result = executeDataRule(publiclyAvailableInformation);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PubliclyAvailableInformation", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PubliclyAvailableInformation", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PubliclyAvailableInformation publiclyAvailableInformation) {
		if (ruleIsApplicable(publiclyAvailableInformation).get()) {
			return evaluateThenExpression(publiclyAvailableInformation);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PubliclyAvailableInformation publiclyAvailableInformation) {
		try {
			return exists(MapperS.of(publiclyAvailableInformation).<Integer>map("getSpecifiedNumber", _publiclyAvailableInformation -> _publiclyAvailableInformation.getSpecifiedNumber()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PubliclyAvailableInformation publiclyAvailableInformation) {
		try {
			return greaterThanEquals(MapperS.of(publiclyAvailableInformation).<Integer>map("getSpecifiedNumber", _publiclyAvailableInformation -> _publiclyAvailableInformation.getSpecifiedNumber()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

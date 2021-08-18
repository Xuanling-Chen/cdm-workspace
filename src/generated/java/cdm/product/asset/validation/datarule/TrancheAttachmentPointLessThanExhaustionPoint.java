package cdm.product.asset.validation.datarule;

import cdm.product.asset.Tranche;
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
@RosettaDataRule("TrancheAttachmentPointLessThanExhaustionPoint")
public class TrancheAttachmentPointLessThanExhaustionPoint implements Validator<Tranche> {
	
	private static final String NAME = "TrancheAttachmentPointLessThanExhaustionPoint";
	private static final String DEFINITION = "if Tranche exists then attachmentPoint <= exhaustionPoint";
	
	
	@Override
	public ValidationResult<Tranche> validate(RosettaPath path, Tranche tranche) {
		ComparisonResult result = executeDataRule(tranche);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Tranche", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Tranche", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Tranche tranche) {
		if (ruleIsApplicable(tranche).get()) {
			return evaluateThenExpression(tranche);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Tranche tranche) {
		try {
			return exists(MapperS.of(tranche));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Tranche tranche) {
		try {
			return lessThanEquals(MapperS.of(tranche).<BigDecimal>map("getAttachmentPoint", _tranche -> _tranche.getAttachmentPoint()), MapperS.of(tranche).<BigDecimal>map("getExhaustionPoint", _tranche -> _tranche.getExhaustionPoint()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

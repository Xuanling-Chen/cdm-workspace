package cdm.product.asset.validation.datarule;

import cdm.base.datetime.Offset;
import cdm.product.asset.DividendDateReference;
import cdm.product.asset.DividendDateReferenceEnum;
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
@RosettaDataRule("DividendDateReferencePaymentDateOffset")
public class DividendDateReferencePaymentDateOffset implements Validator<DividendDateReference> {
	
	private static final String NAME = "DividendDateReferencePaymentDateOffset";
	private static final String DEFINITION = "if paymentDateOffset exists then dateReference = DividendDateReferenceEnum -> SharePayment";
	
	
	@Override
	public ValidationResult<DividendDateReference> validate(RosettaPath path, DividendDateReference dividendDateReference) {
		ComparisonResult result = executeDataRule(dividendDateReference);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "DividendDateReference", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendDateReference", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(DividendDateReference dividendDateReference) {
		if (ruleIsApplicable(dividendDateReference).get()) {
			return evaluateThenExpression(dividendDateReference);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(DividendDateReference dividendDateReference) {
		try {
			return exists(MapperS.of(dividendDateReference).<Offset>map("getPaymentDateOffset", _dividendDateReference -> _dividendDateReference.getPaymentDateOffset()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(DividendDateReference dividendDateReference) {
		try {
			return areEqual(MapperS.of(dividendDateReference).<DividendDateReferenceEnum>map("getDateReference", _dividendDateReference -> _dividendDateReference.getDateReference()), MapperS.of(DividendDateReferenceEnum.SHARE_PAYMENT), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

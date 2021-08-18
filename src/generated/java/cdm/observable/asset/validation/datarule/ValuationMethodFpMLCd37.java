package cdm.observable.asset.validation.datarule;

import cdm.base.math.UnitType;
import cdm.observable.asset.Money;
import cdm.observable.asset.ValuationMethod;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ValuationMethodFpML_cd_37")
public class ValuationMethodFpMLCd37 implements Validator<ValuationMethod> {
	
	private static final String NAME = "ValuationMethodFpML_cd_37";
	private static final String DEFINITION = "if (quotationAmount exists and minimumQuotationAmount exists) and quotationAmount -> unitOfAmount-> currency = minimumQuotationAmount -> unitOfAmount-> currency then quotationAmount -> amount > minimumQuotationAmount -> amount";
	
	
	@Override
	public ValidationResult<ValuationMethod> validate(RosettaPath path, ValuationMethod valuationMethod) {
		ComparisonResult result = executeDataRule(valuationMethod);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ValuationMethod", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ValuationMethod", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ValuationMethod valuationMethod) {
		if (ruleIsApplicable(valuationMethod).get()) {
			return evaluateThenExpression(valuationMethod);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ValuationMethod valuationMethod) {
		try {
			return exists(MapperS.of(valuationMethod).<Money>map("getQuotationAmount", _valuationMethod -> _valuationMethod.getQuotationAmount())).and(exists(MapperS.of(valuationMethod).<Money>map("getMinimumQuotationAmount", _valuationMethod -> _valuationMethod.getMinimumQuotationAmount()))).and(areEqual(MapperS.of(valuationMethod).<Money>map("getQuotationAmount", _valuationMethod -> _valuationMethod.getQuotationAmount()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), MapperS.of(valuationMethod).<Money>map("getMinimumQuotationAmount", _valuationMethod -> _valuationMethod.getMinimumQuotationAmount()).<UnitType>map("getUnitOfAmount", _measureBase -> _measureBase.getUnitOfAmount()).<FieldWithMetaString>map("getCurrency", _unitType -> _unitType.getCurrency()).<String>map("getValue", _f->_f.getValue()), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ValuationMethod valuationMethod) {
		try {
			return greaterThan(MapperS.of(valuationMethod).<Money>map("getQuotationAmount", _valuationMethod -> _valuationMethod.getQuotationAmount()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), MapperS.of(valuationMethod).<Money>map("getMinimumQuotationAmount", _valuationMethod -> _valuationMethod.getMinimumQuotationAmount()).<BigDecimal>map("getAmount", _measureBase -> _measureBase.getAmount()), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

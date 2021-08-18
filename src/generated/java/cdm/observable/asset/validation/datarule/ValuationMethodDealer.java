package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.party.AncillaryEntity;
import cdm.base.staticdata.party.LegalEntity;
import cdm.observable.asset.Money;
import cdm.observable.asset.ValuationMethod;
import cdm.observable.asset.ValuationSource;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("ValuationMethodDealer")
public class ValuationMethodDealer implements Validator<ValuationMethod> {
	
	private static final String NAME = "ValuationMethodDealer";
	private static final String DEFINITION = "if quotationAmount exists or minimumQuotationAmount exists then valuationSource -> dealerOrCCP -> legalEntity exists";
	
	
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
			return exists(MapperS.of(valuationMethod).<Money>map("getQuotationAmount", _valuationMethod -> _valuationMethod.getQuotationAmount())).or(exists(MapperS.of(valuationMethod).<Money>map("getMinimumQuotationAmount", _valuationMethod -> _valuationMethod.getMinimumQuotationAmount())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ValuationMethod valuationMethod) {
		try {
			return exists(MapperS.of(valuationMethod).<ValuationSource>map("getValuationSource", _valuationMethod -> _valuationMethod.getValuationSource()).<AncillaryEntity>map("getDealerOrCCP", _valuationSource -> _valuationSource.getDealerOrCCP()).<LegalEntity>map("getLegalEntity", _ancillaryEntity -> _ancillaryEntity.getLegalEntity()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

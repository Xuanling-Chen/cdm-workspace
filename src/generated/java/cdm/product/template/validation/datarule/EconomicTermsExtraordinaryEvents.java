package cdm.product.template.validation.datarule;

import cdm.observable.event.ExtraordinaryEvents;
import cdm.product.template.EconomicTerms;
import cdm.product.template.EquityPayout;
import cdm.product.template.Payout;
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
@RosettaDataRule("EconomicTermsExtraordinaryEvents")
public class EconomicTermsExtraordinaryEvents implements Validator<EconomicTerms> {
	
	private static final String NAME = "EconomicTermsExtraordinaryEvents";
	private static final String DEFINITION = "if extraordinaryEvents exists then payout -> equityPayout exists";
	
	
	@Override
	public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
		ComparisonResult result = executeDataRule(economicTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "EconomicTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
		if (ruleIsApplicable(economicTerms).get()) {
			return evaluateThenExpression(economicTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(EconomicTerms economicTerms) {
		try {
			return exists(MapperS.of(economicTerms).<ExtraordinaryEvents>map("getExtraordinaryEvents", _economicTerms -> _economicTerms.getExtraordinaryEvents()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EconomicTerms economicTerms) {
		try {
			return exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<EquityPayout>mapC("getEquityPayout", _payout -> _payout.getEquityPayout()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

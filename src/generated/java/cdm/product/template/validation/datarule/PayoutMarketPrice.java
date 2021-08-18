package cdm.product.template.validation.datarule;

import cdm.observable.asset.TransactedPrice;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.IndexReferenceInformation;
import cdm.product.template.Payout;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;

import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PayoutMarketPrice")
public class PayoutMarketPrice implements Validator<Payout> {
	
	private static final String NAME = "PayoutMarketPrice";
	private static final String DEFINITION = "if creditDefaultPayout -> generalTerms -> indexReferenceInformation is absent then creditDefaultPayout -> transactedPrice -> marketFixedRate is absent and creditDefaultPayout -> transactedPrice -> marketPrice is absent";
	
	
	@Override
	public ValidationResult<Payout> validate(RosettaPath path, Payout payout) {
		ComparisonResult result = executeDataRule(payout);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Payout", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Payout", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Payout payout) {
		if (ruleIsApplicable(payout).get()) {
			return evaluateThenExpression(payout);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Payout payout) {
		try {
			return notExists(MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<IndexReferenceInformation>map("getIndexReferenceInformation", _generalTerms -> _generalTerms.getIndexReferenceInformation()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Payout payout) {
		try {
			return notExists(MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<TransactedPrice>map("getTransactedPrice", _creditDefaultPayout -> _creditDefaultPayout.getTransactedPrice()).<BigDecimal>map("getMarketFixedRate", _transactedPrice -> _transactedPrice.getMarketFixedRate())).and(notExists(MapperS.of(payout).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<TransactedPrice>map("getTransactedPrice", _creditDefaultPayout -> _creditDefaultPayout.getTransactedPrice()).<BigDecimal>map("getMarketPrice", _transactedPrice -> _transactedPrice.getMarketPrice())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

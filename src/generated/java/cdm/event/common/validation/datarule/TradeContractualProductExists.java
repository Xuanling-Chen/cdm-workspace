package cdm.event.common.validation.datarule;

import cdm.event.common.Trade;
import cdm.product.template.ContractualProduct;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeContractualProductExists")
public class TradeContractualProductExists implements Validator<Trade> {
	
	private static final String NAME = "TradeContractualProductExists";
	private static final String DEFINITION = "tradableProduct -> product -> contractualProduct only exists";
	
	
	@Override
	public ValidationResult<Trade> validate(RosettaPath path, Trade trade) {
		ComparisonResult result = executeDataRule(trade);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Trade", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Trade trade) {
		if (ruleIsApplicable(trade).get()) {
			return evaluateThenExpression(trade);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Trade trade) {
		try {
			return ComparisonResult.success();
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return onlyExists(Arrays.asList(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

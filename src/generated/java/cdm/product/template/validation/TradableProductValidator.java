package cdm.product.template.validation;

import cdm.product.template.TradableProduct;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class TradableProductValidator implements Validator<TradableProduct> {

	@Override
	public ValidationResult<TradableProduct> validate(RosettaPath path, TradableProduct o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("product", o.getProduct()!=null ? 1 : 0, 1, 1),
				checkCardinality("tradeLot", o.getTradeLot()==null?0:o.getTradeLot().size(), 1, 0),
				checkCardinality("counterparty", o.getCounterparty()==null?0:o.getCounterparty().size(), 2, 2),
				checkCardinality("ancillaryParty", o.getAncillaryParty()==null?0:o.getAncillaryParty().size(), 0, 0),
				checkCardinality("settlementInstructions", o.getSettlementInstructions()==null?0:o.getSettlementInstructions().size(), 0, 0),
				checkCardinality("adjustment", o.getAdjustment()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TradableProduct", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TradableProduct", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.event.common.validation;

import cdm.event.common.Trade;
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

public class TradeValidator implements Validator<Trade> {

	@Override
	public ValidationResult<Trade> validate(RosettaPath path, Trade o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeIdentifier", o.getTradeIdentifier()==null?0:o.getTradeIdentifier().size(), 1, 0),
				checkCardinality("tradeDate", o.getTradeDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("tradableProduct", o.getTradableProduct()!=null ? 1 : 0, 1, 1),
				checkCardinality("party", o.getParty()==null?0:o.getParty().size(), 0, 0),
				checkCardinality("partyRole", o.getPartyRole()==null?0:o.getPartyRole().size(), 0, 0),
				checkCardinality("executionDetails", o.getExecutionDetails()!=null ? 1 : 0, 0, 1),
				checkCardinality("contractDetails", o.getContractDetails()!=null ? 1 : 0, 0, 1),
				checkCardinality("clearedDate", o.getClearedDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("collateral", o.getCollateral()!=null ? 1 : 0, 0, 1),
				checkCardinality("account", o.getAccount()==null?0:o.getAccount().size(), 0, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Trade", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Trade", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

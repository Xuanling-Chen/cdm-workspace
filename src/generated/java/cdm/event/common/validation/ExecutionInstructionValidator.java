package cdm.event.common.validation;

import cdm.event.common.ExecutionInstruction;
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

public class ExecutionInstructionValidator implements Validator<ExecutionInstruction> {

	@Override
	public ValidationResult<ExecutionInstruction> validate(RosettaPath path, ExecutionInstruction o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("product", o.getProduct()!=null ? 1 : 0, 1, 1),
				checkCardinality("priceQuantity", o.getPriceQuantity()==null?0:o.getPriceQuantity().size(), 1, 0),
				checkCardinality("counterparty", o.getCounterparty()==null?0:o.getCounterparty().size(), 2, 2),
				checkCardinality("ancillaryParty", o.getAncillaryParty()==null?0:o.getAncillaryParty().size(), 0, 0),
				checkCardinality("parties", o.getParties()==null?0:o.getParties().size(), 2, 0),
				checkCardinality("partyRoles", o.getPartyRoles()==null?0:o.getPartyRoles().size(), 0, 0),
				checkCardinality("settlementInstructions", o.getSettlementInstructions()==null?0:o.getSettlementInstructions().size(), 0, 0),
				checkCardinality("executionDetails", o.getExecutionDetails()!=null ? 1 : 0, 1, 1),
				checkCardinality("tradeDate", o.getTradeDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("tradeIdentifier", o.getTradeIdentifier()==null?0:o.getTradeIdentifier().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ExecutionInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ExecutionInstruction", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

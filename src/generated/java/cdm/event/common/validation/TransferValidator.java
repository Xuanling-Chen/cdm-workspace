package cdm.event.common.validation;

import cdm.event.common.Transfer;
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

public class TransferValidator implements Validator<Transfer> {

	@Override
	public ValidationResult<Transfer> validate(RosettaPath path, Transfer o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", o.getIdentifier()==null?0:o.getIdentifier().size(), 0, 0),
				checkCardinality("quantity", o.getQuantity()!=null ? 1 : 0, 1, 1),
				checkCardinality("observable", o.getObservable()!=null ? 1 : 0, 0, 1),
				checkCardinality("payerReceiver", o.getPayerReceiver()!=null ? 1 : 0, 1, 1),
				checkCardinality("settlementDate", o.getSettlementDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("settlementOrigin", o.getSettlementOrigin()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Transfer", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Transfer", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

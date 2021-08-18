package cdm.event.common.validation;

import cdm.event.common.CashTransferComponent;
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

public class CashTransferComponentValidator implements Validator<CashTransferComponent> {

	@Override
	public ValidationResult<CashTransferComponent> validate(RosettaPath path, CashTransferComponent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerReceiver", o.getPayerReceiver()!=null ? 1 : 0, 1, 1),
				checkCardinality("amount", o.getAmount()!=null ? 1 : 0, 1, 1),
				checkCardinality("cashflowType", o.getCashflowType()!=null ? 1 : 0, 0, 1),
				checkCardinality("breakdown", o.getBreakdown()==null?0:o.getBreakdown().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CashTransferComponent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CashTransferComponent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.product.asset.validation;

import cdm.product.asset.CashflowRepresentation;
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

public class CashflowRepresentationValidator implements Validator<CashflowRepresentation> {

	@Override
	public ValidationResult<CashflowRepresentation> validate(RosettaPath path, CashflowRepresentation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashflowsMatchParameters", o.getCashflowsMatchParameters()!=null ? 1 : 0, 1, 1),
				checkCardinality("principalExchange", o.getPrincipalExchange()==null?0:o.getPrincipalExchange().size(), 0, 0),
				checkCardinality("paymentCalculationPeriod", o.getPaymentCalculationPeriod()==null?0:o.getPaymentCalculationPeriod().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CashflowRepresentation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CashflowRepresentation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

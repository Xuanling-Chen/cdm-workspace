package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.SimplePayment;
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

public class SimplePaymentValidator implements Validator<SimplePayment> {

	@Override
	public ValidationResult<SimplePayment> validate(RosettaPath path, SimplePayment o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentAmount", o.getPaymentAmount()!=null ? 1 : 0, 1, 1),
				checkCardinality("paymentDate", o.getPaymentDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SimplePayment", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SimplePayment", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

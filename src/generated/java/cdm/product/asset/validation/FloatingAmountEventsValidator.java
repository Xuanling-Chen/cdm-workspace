package cdm.product.asset.validation;

import cdm.product.asset.FloatingAmountEvents;
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

public class FloatingAmountEventsValidator implements Validator<FloatingAmountEvents> {

	@Override
	public ValidationResult<FloatingAmountEvents> validate(RosettaPath path, FloatingAmountEvents o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("failureToPayPrincipal", o.getFailureToPayPrincipal()!=null ? 1 : 0, 0, 1),
				checkCardinality("interestShortfall", o.getInterestShortfall()!=null ? 1 : 0, 0, 1),
				checkCardinality("writedown", o.getWritedown()!=null ? 1 : 0, 0, 1),
				checkCardinality("impliedWritedown", o.getImpliedWritedown()!=null ? 1 : 0, 0, 1),
				checkCardinality("floatingAmountProvisions", o.getFloatingAmountProvisions()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalFixedPayments", o.getAdditionalFixedPayments()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FloatingAmountEvents", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FloatingAmountEvents", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

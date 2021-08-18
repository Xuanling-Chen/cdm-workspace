package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.CreditSupportObligations;
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

public class CreditSupportObligationsValidator implements Validator<CreditSupportObligations> {

	@Override
	public ValidationResult<CreditSupportObligations> validate(RosettaPath path, CreditSupportObligations o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("deliveryAmount", o.getDeliveryAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("returnAmount", o.getReturnAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("marginApproach", o.getMarginApproach()!=null ? 1 : 0, 0, 1),
				checkCardinality("otherEligibleSupport", o.getOtherEligibleSupport()!=null ? 1 : 0, 0, 1),
				checkCardinality("threshold", o.getThreshold()!=null ? 1 : 0, 1, 1),
				checkCardinality("minimumTransferAmount", o.getMinimumTransferAmount()!=null ? 1 : 0, 1, 1),
				checkCardinality("rounding", o.getRounding()!=null ? 1 : 0, 0, 1),
				checkCardinality("bespokeTransferTiming", o.getBespokeTransferTiming()!=null ? 1 : 0, 0, 1),
				checkCardinality("creditSupportObligationsVariationMargin", o.getCreditSupportObligationsVariationMargin()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditSupportObligations", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditSupportObligations", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

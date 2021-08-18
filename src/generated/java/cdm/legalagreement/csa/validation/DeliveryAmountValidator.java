package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.DeliveryAmount;
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

public class DeliveryAmountValidator implements Validator<DeliveryAmount> {

	@Override
	public ValidationResult<DeliveryAmount> validate(RosettaPath path, DeliveryAmount o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardElection", o.getStandardElection()!=null ? 1 : 0, 0, 1),
				checkCardinality("customElection", o.getCustomElection()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DeliveryAmount", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DeliveryAmount", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.event.workflow.validation;

import cdm.event.workflow.CreditLimitUtilisationPosition;
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

public class CreditLimitUtilisationPositionValidator implements Validator<CreditLimitUtilisationPosition> {

	@Override
	public ValidationResult<CreditLimitUtilisationPosition> validate(RosettaPath path, CreditLimitUtilisationPosition o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("shortPosition", o.getShortPosition()!=null ? 1 : 0, 0, 1),
				checkCardinality("longPosition", o.getLongPosition()!=null ? 1 : 0, 0, 1),
				checkCardinality("global", o.getGlobal()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditLimitUtilisationPosition", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditLimitUtilisationPosition", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.BespokeTransferTiming;
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

public class BespokeTransferTimingValidator implements Validator<BespokeTransferTiming> {

	@Override
	public ValidationResult<BespokeTransferTiming> validate(RosettaPath path, BespokeTransferTiming o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", o.getIsApplicable()!=null ? 1 : 0, 1, 1),
				checkCardinality("bespokeTransferTimingTerms", o.getBespokeTransferTimingTerms()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("BespokeTransferTiming", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("BespokeTransferTiming", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

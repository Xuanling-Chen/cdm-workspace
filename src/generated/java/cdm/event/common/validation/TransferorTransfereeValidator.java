package cdm.event.common.validation;

import cdm.event.common.TransferorTransferee;
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

public class TransferorTransfereeValidator implements Validator<TransferorTransferee> {

	@Override
	public ValidationResult<TransferorTransferee> validate(RosettaPath path, TransferorTransferee o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("transferorPartyReference", o.getTransferorPartyReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("transferorAccountReference", o.getTransferorAccountReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("transfereePartyReference", o.getTransfereePartyReference()!=null ? 1 : 0, 1, 1),
				checkCardinality("transfereeAccountReference", o.getTransfereeAccountReference()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TransferorTransferee", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TransferorTransferee", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

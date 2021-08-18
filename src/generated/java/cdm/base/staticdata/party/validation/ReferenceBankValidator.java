package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.ReferenceBank;
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

public class ReferenceBankValidator implements Validator<ReferenceBank> {

	@Override
	public ValidationResult<ReferenceBank> validate(RosettaPath path, ReferenceBank o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceBankId", o.getReferenceBankId()!=null ? 1 : 0, 1, 1),
				checkCardinality("referenceBankName", o.getReferenceBankName()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ReferenceBank", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ReferenceBank", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

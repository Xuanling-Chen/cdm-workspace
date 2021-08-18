package cdm.event.common.validation;

import cdm.event.common.SecurityTransferBreakdown;
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

public class SecurityTransferBreakdownValidator implements Validator<SecurityTransferBreakdown> {

	@Override
	public ValidationResult<SecurityTransferBreakdown> validate(RosettaPath path, SecurityTransferBreakdown o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("transferorTransferee", o.getTransferorTransferee()!=null ? 1 : 0, 1, 1),
				checkCardinality("security", o.getSecurity()==null?0:o.getSecurity().size(), 1, 0),
				checkCardinality("quantity", o.getQuantity()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SecurityTransferBreakdown", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SecurityTransferBreakdown", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

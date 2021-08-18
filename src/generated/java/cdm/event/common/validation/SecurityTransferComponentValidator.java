package cdm.event.common.validation;

import cdm.event.common.SecurityTransferComponent;
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

public class SecurityTransferComponentValidator implements Validator<SecurityTransferComponent> {

	@Override
	public ValidationResult<SecurityTransferComponent> validate(RosettaPath path, SecurityTransferComponent o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("transferorTransferee", o.getTransferorTransferee()!=null ? 1 : 0, 1, 1),
				checkCardinality("security", o.getSecurity()!=null ? 1 : 0, 1, 1),
				checkCardinality("quantity", o.getQuantity()!=null ? 1 : 0, 1, 1),
				checkCardinality("assetTransferType", o.getAssetTransferType()!=null ? 1 : 0, 0, 1),
				checkCardinality("breakdown", o.getBreakdown()==null?0:o.getBreakdown().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SecurityTransferComponent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SecurityTransferComponent", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.legalagreement.contract.validation;

import cdm.legalagreement.contract.IssuerTradeId;
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

public class IssuerTradeIdValidator implements Validator<IssuerTradeId> {

	@Override
	public ValidationResult<IssuerTradeId> validate(RosettaPath path, IssuerTradeId o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuer", o.getIssuer()!=null ? 1 : 0, 1, 1),
				checkCardinality("identifier", o.getIdentifier()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("IssuerTradeId", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("IssuerTradeId", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

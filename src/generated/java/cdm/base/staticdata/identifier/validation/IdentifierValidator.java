package cdm.base.staticdata.identifier.validation;

import cdm.base.staticdata.identifier.Identifier;
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

public class IdentifierValidator implements Validator<Identifier> {

	@Override
	public ValidationResult<Identifier> validate(RosettaPath path, Identifier o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerReference", o.getIssuerReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("issuer", o.getIssuer()!=null ? 1 : 0, 0, 1),
				checkCardinality("assignedIdentifier", o.getAssignedIdentifier()==null?0:o.getAssignedIdentifier().size(), 1, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Identifier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Identifier", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

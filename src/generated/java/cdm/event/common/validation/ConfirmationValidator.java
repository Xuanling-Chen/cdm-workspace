package cdm.event.common.validation;

import cdm.event.common.Confirmation;
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

public class ConfirmationValidator implements Validator<Confirmation> {

	@Override
	public ValidationResult<Confirmation> validate(RosettaPath path, Confirmation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("identifier", o.getIdentifier()==null?0:o.getIdentifier().size(), 1, 0),
				checkCardinality("party", o.getParty()==null?0:o.getParty().size(), 1, 0),
				checkCardinality("partyRole", o.getPartyRole()==null?0:o.getPartyRole().size(), 1, 0),
				checkCardinality("lineage", o.getLineage()!=null ? 1 : 0, 0, 1),
				checkCardinality("status", o.getStatus()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Confirmation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Confirmation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.ReferenceBanks;
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

public class ReferenceBanksValidator implements Validator<ReferenceBanks> {

	@Override
	public ValidationResult<ReferenceBanks> validate(RosettaPath path, ReferenceBanks o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("referenceBank", o.getReferenceBank()==null?0:o.getReferenceBank().size(), 1, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ReferenceBanks", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ReferenceBanks", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

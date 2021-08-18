package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.SimmVersion;
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

public class SimmVersionValidator implements Validator<SimmVersion> {

	@Override
	public ValidationResult<SimmVersion> validate(RosettaPath path, SimmVersion o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("isSpecified", o.getIsSpecified()!=null ? 1 : 0, 0, 1),
				checkCardinality("partyVersion", o.getPartyVersion()!=null ? 1 : 0, 0, 1),
				checkCardinality("asSpecified", o.getAsSpecified()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SimmVersion", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SimmVersion", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.observable.event.validation;

import cdm.observable.event.Representations;
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

public class RepresentationsValidator implements Validator<Representations> {

	@Override
	public ValidationResult<Representations> validate(RosettaPath path, Representations o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("nonReliance", o.getNonReliance()!=null ? 1 : 0, 1, 1),
				checkCardinality("agreementsRegardingHedging", o.getAgreementsRegardingHedging()!=null ? 1 : 0, 1, 1),
				checkCardinality("indexDisclaimer", o.getIndexDisclaimer()!=null ? 1 : 0, 1, 1),
				checkCardinality("additionalAcknowledgements", o.getAdditionalAcknowledgements()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Representations", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Representations", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

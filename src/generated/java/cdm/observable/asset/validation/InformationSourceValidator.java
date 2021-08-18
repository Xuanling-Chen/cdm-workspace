package cdm.observable.asset.validation;

import cdm.observable.asset.InformationSource;
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

public class InformationSourceValidator implements Validator<InformationSource> {

	@Override
	public ValidationResult<InformationSource> validate(RosettaPath path, InformationSource o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("sourceProvider", o.getSourceProvider()!=null ? 1 : 0, 1, 1),
				checkCardinality("sourcePage", o.getSourcePage()!=null ? 1 : 0, 0, 1),
				checkCardinality("sourcePageHeading", o.getSourcePageHeading()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("InformationSource", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("InformationSource", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

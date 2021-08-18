package cdm.event.common.validation;

import cdm.event.common.PackageInformation;
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

public class PackageInformationValidator implements Validator<PackageInformation> {

	@Override
	public ValidationResult<PackageInformation> validate(RosettaPath path, PackageInformation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("relatedParty", o.getRelatedParty()==null?0:o.getRelatedParty().size(), 0, 0),
				checkCardinality("category", o.getCategory()==null?0:o.getCategory().size(), 0, 0),
				checkCardinality("intentToAllocate", o.getIntentToAllocate()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PackageInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PackageInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

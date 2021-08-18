package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.AgencyRatingCriteria;
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

public class AgencyRatingCriteriaValidator implements Validator<AgencyRatingCriteria> {

	@Override
	public ValidationResult<AgencyRatingCriteria> validate(RosettaPath path, AgencyRatingCriteria o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("qualifier", o.getQualifier()!=null ? 1 : 0, 1, 1),
				checkCardinality("creditNotation", o.getCreditNotation()==null?0:o.getCreditNotation().size(), 1, 0),
				checkCardinality("mismatchResolution", o.getMismatchResolution()!=null ? 1 : 0, 0, 1),
				checkCardinality("referenceAgency", o.getReferenceAgency()!=null ? 1 : 0, 0, 1),
				checkCardinality("boundary", o.getBoundary()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AgencyRatingCriteria", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AgencyRatingCriteria", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

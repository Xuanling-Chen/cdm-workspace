package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.ListingType;
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

public class ListingTypeValidator implements Validator<ListingType> {

	@Override
	public ValidationResult<ListingType> validate(RosettaPath path, ListingType o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("exchange", o.getExchange()!=null ? 1 : 0, 0, 1),
				checkCardinality("sector", o.getSector()!=null ? 1 : 0, 0, 1),
				checkCardinality("index", o.getIndex()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ListingType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ListingType", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

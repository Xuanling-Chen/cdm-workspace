package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.TelephoneNumber;
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

public class TelephoneNumberValidator implements Validator<TelephoneNumber> {

	@Override
	public ValidationResult<TelephoneNumber> validate(RosettaPath path, TelephoneNumber o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("telephoneNumberType", o.getTelephoneNumberType()!=null ? 1 : 0, 0, 1),
				checkCardinality("number", o.getNumber()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("TelephoneNumber", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("TelephoneNumber", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

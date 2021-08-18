package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.Address;
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

public class AddressValidator implements Validator<Address> {

	@Override
	public ValidationResult<Address> validate(RosettaPath path, Address o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("street", o.getStreet()==null?0:o.getStreet().size(), 1, 0),
				checkCardinality("city", o.getCity()!=null ? 1 : 0, 1, 1),
				checkCardinality("state", o.getState()!=null ? 1 : 0, 0, 1),
				checkCardinality("country", o.getCountry()!=null ? 1 : 0, 1, 1),
				checkCardinality("postalCode", o.getPostalCode()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Address", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Address", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

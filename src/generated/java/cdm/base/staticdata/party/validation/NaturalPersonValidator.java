package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.NaturalPerson;
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

public class NaturalPersonValidator implements Validator<NaturalPerson> {

	@Override
	public ValidationResult<NaturalPerson> validate(RosettaPath path, NaturalPerson o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("honorific", o.getHonorific()!=null ? 1 : 0, 0, 1),
				checkCardinality("firstName", o.getFirstName()!=null ? 1 : 0, 1, 1),
				checkCardinality("middleName", o.getMiddleName()==null?0:o.getMiddleName().size(), 0, 0),
				checkCardinality("initial", o.getInitial()==null?0:o.getInitial().size(), 0, 0),
				checkCardinality("surname", o.getSurname()!=null ? 1 : 0, 1, 1),
				checkCardinality("suffix", o.getSuffix()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateOfBirth", o.getDateOfBirth()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("NaturalPerson", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("NaturalPerson", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

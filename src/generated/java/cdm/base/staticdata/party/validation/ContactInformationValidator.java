package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.ContactInformation;
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

public class ContactInformationValidator implements Validator<ContactInformation> {

	@Override
	public ValidationResult<ContactInformation> validate(RosettaPath path, ContactInformation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("telephone", o.getTelephone()==null?0:o.getTelephone().size(), 0, 0),
				checkCardinality("address", o.getAddress()==null?0:o.getAddress().size(), 0, 0),
				checkCardinality("email", o.getEmail()==null?0:o.getEmail().size(), 0, 0),
				checkCardinality("webPage", o.getWebPage()==null?0:o.getWebPage().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ContactInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ContactInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

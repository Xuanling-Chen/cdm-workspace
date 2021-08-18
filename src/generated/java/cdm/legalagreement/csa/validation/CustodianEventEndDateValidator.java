package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.CustodianEventEndDate;
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

public class CustodianEventEndDateValidator implements Validator<CustodianEventEndDate> {

	@Override
	public ValidationResult<CustodianEventEndDate> validate(RosettaPath path, CustodianEventEndDate o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("daysAfterCustodianEvent", o.getDaysAfterCustodianEvent()!=null ? 1 : 0, 1, 1),
				checkCardinality("releaseDate", o.getReleaseDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("safekeepingPeriodExpiry", o.getSafekeepingPeriodExpiry()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateOfTimelyStatement", o.getDateOfTimelyStatement()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CustodianEventEndDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CustodianEventEndDate", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

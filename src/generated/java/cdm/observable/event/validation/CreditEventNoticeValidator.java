package cdm.observable.event.validation;

import cdm.observable.event.CreditEventNotice;
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

public class CreditEventNoticeValidator implements Validator<CreditEventNotice> {

	@Override
	public ValidationResult<CreditEventNotice> validate(RosettaPath path, CreditEventNotice o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("notifyingParty", o.getNotifyingParty()==null?0:o.getNotifyingParty().size(), 1, 2),
				checkCardinality("businessCenter", o.getBusinessCenter()!=null ? 1 : 0, 0, 1),
				checkCardinality("publiclyAvailableInformation", o.getPubliclyAvailableInformation()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditEventNotice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditEventNotice", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

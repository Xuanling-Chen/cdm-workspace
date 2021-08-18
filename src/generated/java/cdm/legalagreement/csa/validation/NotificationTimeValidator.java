package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.NotificationTime;
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

public class NotificationTimeValidator implements Validator<NotificationTime> {

	@Override
	public ValidationResult<NotificationTime> validate(RosettaPath path, NotificationTime o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyElections", o.getPartyElections()==null?0:o.getPartyElections().size(), 2, 2),
				checkCardinality("disputeNotificationReference", o.getDisputeNotificationReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("transferTimingProviso", o.getTransferTimingProviso()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("NotificationTime", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("NotificationTime", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

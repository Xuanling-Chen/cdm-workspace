package cdm.event.workflow.validation;

import cdm.event.workflow.MessageInformation;
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

public class MessageInformationValidator implements Validator<MessageInformation> {

	@Override
	public ValidationResult<MessageInformation> validate(RosettaPath path, MessageInformation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("messageId", o.getMessageId()!=null ? 1 : 0, 1, 1),
				checkCardinality("sentBy", o.getSentBy()!=null ? 1 : 0, 0, 1),
				checkCardinality("sentTo", o.getSentTo()==null?0:o.getSentTo().size(), 0, 0),
				checkCardinality("copyTo", o.getCopyTo()==null?0:o.getCopyTo().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MessageInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MessageInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

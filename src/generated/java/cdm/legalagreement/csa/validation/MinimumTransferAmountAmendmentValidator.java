package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.MinimumTransferAmountAmendment;
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

public class MinimumTransferAmountAmendmentValidator implements Validator<MinimumTransferAmountAmendment> {

	@Override
	public ValidationResult<MinimumTransferAmountAmendment> validate(RosettaPath path, MinimumTransferAmountAmendment o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", o.getIsApplicable()!=null ? 1 : 0, 1, 1),
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("partyElections", o.getPartyElections()==null?0:o.getPartyElections().size(), 0, 2)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MinimumTransferAmountAmendment", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MinimumTransferAmountAmendment", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

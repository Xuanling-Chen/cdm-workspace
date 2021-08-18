package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.IneligibleCreditSupport;
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

public class IneligibleCreditSupportValidator implements Validator<IneligibleCreditSupport> {

	@Override
	public ValidationResult<IneligibleCreditSupport> validate(RosettaPath path, IneligibleCreditSupport o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("totalIneligibilityDate", o.getTotalIneligibilityDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("transferIneligibilityDate", o.getTransferIneligibilityDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("specifiedParty", o.getSpecifiedParty()==null?0:o.getSpecifiedParty().size(), 0, 2)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("IneligibleCreditSupport", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("IneligibleCreditSupport", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

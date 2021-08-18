package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.DistributionAndInterestPayment;
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

public class DistributionAndInterestPaymentValidator implements Validator<DistributionAndInterestPayment> {

	@Override
	public ValidationResult<DistributionAndInterestPayment> validate(RosettaPath path, DistributionAndInterestPayment o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("interestRate", o.getInterestRate()==null?0:o.getInterestRate().size(), 1, 0),
				checkCardinality("interestPaymentTransfer", o.getInterestPaymentTransfer()!=null ? 1 : 0, 1, 1),
				checkCardinality("interestPaymentNetting", o.getInterestPaymentNetting()!=null ? 1 : 0, 1, 1),
				checkCardinality("interestAmount", o.getInterestAmount()!=null ? 1 : 0, 1, 1),
				checkCardinality("interestAdjustment", o.getInterestAdjustment()!=null ? 1 : 0, 1, 1),
				checkCardinality("negativeInterest", o.getNegativeInterest()!=null ? 1 : 0, 1, 1),
				checkCardinality("dailyInterestCompounding", o.getDailyInterestCompounding()!=null ? 1 : 0, 1, 1),
				checkCardinality("alternativeProvision", o.getAlternativeProvision()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DistributionAndInterestPayment", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DistributionAndInterestPayment", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.event.common.validation;

import cdm.event.common.SettlementOrigin;
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

public class SettlementOriginValidator implements Validator<SettlementOrigin> {

	@Override
	public ValidationResult<SettlementOrigin> validate(RosettaPath path, SettlementOrigin o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("interestRatePayout", o.getInterestRatePayout()!=null ? 1 : 0, 0, 1),
				checkCardinality("equityPayout", o.getEquityPayout()!=null ? 1 : 0, 0, 1),
				checkCardinality("securityPayout", o.getSecurityPayout()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashflow", o.getCashflow()!=null ? 1 : 0, 0, 1),
				checkCardinality("settlementTerms", o.getSettlementTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("physicalSettlementTerms", o.getPhysicalSettlementTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashSettlementTerms", o.getCashSettlementTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("securityFinancePayout", o.getSecurityFinancePayout()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SettlementOrigin", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SettlementOrigin", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

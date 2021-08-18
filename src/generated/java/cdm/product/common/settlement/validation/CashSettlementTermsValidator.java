package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.CashSettlementTerms;
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

public class CashSettlementTermsValidator implements Validator<CashSettlementTerms> {

	@Override
	public ValidationResult<CashSettlementTerms> validate(RosettaPath path, CashSettlementTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementMethod", o.getCashSettlementMethod()!=null ? 1 : 0, 0, 1),
				checkCardinality("valuationMethod", o.getValuationMethod()!=null ? 1 : 0, 0, 1),
				checkCardinality("valuationDate", o.getValuationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("valuationTime", o.getValuationTime()!=null ? 1 : 0, 0, 1),
				checkCardinality("cashSettlementAmount", o.getCashSettlementAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("recoveryFactor", o.getRecoveryFactor()!=null ? 1 : 0, 0, 1),
				checkCardinality("fixedSettlement", o.getFixedSettlement()!=null ? 1 : 0, 0, 1),
				checkCardinality("accruedInterest", o.getAccruedInterest()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CashSettlementTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CashSettlementTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.SettlementTerms;
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

public class SettlementTermsValidator implements Validator<SettlementTerms> {

	@Override
	public ValidationResult<SettlementTerms> validate(RosettaPath path, SettlementTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementTerms", o.getCashSettlementTerms()==null?0:o.getCashSettlementTerms().size(), 0, 0),
				checkCardinality("physicalSettlementTerms", o.getPhysicalSettlementTerms()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SettlementTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SettlementTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}
package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.PhysicalSettlementTerms;
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

public class PhysicalSettlementTermsValidator implements Validator<PhysicalSettlementTerms> {

	@Override
	public ValidationResult<PhysicalSettlementTerms> validate(RosettaPath path, PhysicalSettlementTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("clearedPhysicalSettlement", o.getClearedPhysicalSettlement()!=null ? 1 : 0, 0, 1),
				checkCardinality("predeterminedClearingOrganizationParty", o.getPredeterminedClearingOrganizationParty()!=null ? 1 : 0, 0, 1),
				checkCardinality("physicalSettlementPeriod", o.getPhysicalSettlementPeriod()!=null ? 1 : 0, 0, 1),
				checkCardinality("deliverableObligations", o.getDeliverableObligations()!=null ? 1 : 0, 0, 1),
				checkCardinality("escrow", o.getEscrow()!=null ? 1 : 0, 0, 1),
				checkCardinality("sixtyBusinessDaySettlementCap", o.getSixtyBusinessDaySettlementCap()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PhysicalSettlementTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PhysicalSettlementTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

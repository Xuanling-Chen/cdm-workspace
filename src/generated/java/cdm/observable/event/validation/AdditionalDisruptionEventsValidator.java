package cdm.observable.event.validation;

import cdm.observable.event.AdditionalDisruptionEvents;
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

public class AdditionalDisruptionEventsValidator implements Validator<AdditionalDisruptionEvents> {

	@Override
	public ValidationResult<AdditionalDisruptionEvents> validate(RosettaPath path, AdditionalDisruptionEvents o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("changeInLaw", o.getChangeInLaw()!=null ? 1 : 0, 0, 1),
				checkCardinality("failureToDeliver", o.getFailureToDeliver()!=null ? 1 : 0, 0, 1),
				checkCardinality("insolvencyFiling", o.getInsolvencyFiling()!=null ? 1 : 0, 0, 1),
				checkCardinality("hedgingDisruption", o.getHedgingDisruption()!=null ? 1 : 0, 0, 1),
				checkCardinality("increasedCostOfHedging", o.getIncreasedCostOfHedging()!=null ? 1 : 0, 0, 1),
				checkCardinality("foreignOwnershipEvent", o.getForeignOwnershipEvent()!=null ? 1 : 0, 0, 1),
				checkCardinality("lossOfStockBorrow", o.getLossOfStockBorrow()!=null ? 1 : 0, 0, 1),
				checkCardinality("maximumStockLoanRate", o.getMaximumStockLoanRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("increasedCostOfStockBorrow", o.getIncreasedCostOfStockBorrow()!=null ? 1 : 0, 0, 1),
				checkCardinality("initialStockLoanRate", o.getInitialStockLoanRate()!=null ? 1 : 0, 0, 1),
				checkCardinality("determiningParty", o.getDeterminingParty()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AdditionalDisruptionEvents", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AdditionalDisruptionEvents", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

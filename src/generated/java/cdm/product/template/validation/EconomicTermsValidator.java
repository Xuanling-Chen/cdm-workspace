package cdm.product.template.validation;

import cdm.product.template.EconomicTerms;
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

public class EconomicTermsValidator implements Validator<EconomicTerms> {

	@Override
	public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("effectiveDate", o.getEffectiveDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("terminationDate", o.getTerminationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("dateAdjustments", o.getDateAdjustments()!=null ? 1 : 0, 0, 1),
				checkCardinality("payout", o.getPayout()!=null ? 1 : 0, 1, 1),
				checkCardinality("earlyTerminationProvision", o.getEarlyTerminationProvision()!=null ? 1 : 0, 0, 1),
				checkCardinality("optionProvision", o.getOptionProvision()!=null ? 1 : 0, 0, 1),
				checkCardinality("extraordinaryEvents", o.getExtraordinaryEvents()!=null ? 1 : 0, 0, 1),
				checkCardinality("calculationAgent", o.getCalculationAgent()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("EconomicTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("EconomicTerms", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

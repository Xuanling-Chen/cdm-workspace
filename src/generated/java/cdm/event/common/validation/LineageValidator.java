package cdm.event.common.validation;

import cdm.event.common.Lineage;
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

public class LineageValidator implements Validator<Lineage> {

	@Override
	public ValidationResult<Lineage> validate(RosettaPath path, Lineage o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("tradeReference", o.getTradeReference()==null?0:o.getTradeReference().size(), 0, 0),
				checkCardinality("eventReference", o.getEventReference()==null?0:o.getEventReference().size(), 0, 0),
				checkCardinality("cashflowReference", o.getCashflowReference()==null?0:o.getCashflowReference().size(), 0, 0),
				checkCardinality("creditDefaultPayoutReference", o.getCreditDefaultPayoutReference()==null?0:o.getCreditDefaultPayoutReference().size(), 0, 0),
				checkCardinality("interestRatePayoutReference", o.getInterestRatePayoutReference()==null?0:o.getInterestRatePayoutReference().size(), 0, 0),
				checkCardinality("optionPayoutReference", o.getOptionPayoutReference()==null?0:o.getOptionPayoutReference().size(), 0, 0),
				checkCardinality("equityPayoutReference", o.getEquityPayoutReference()==null?0:o.getEquityPayoutReference().size(), 0, 0),
				checkCardinality("transferReference", o.getTransferReference()==null?0:o.getTransferReference().size(), 0, 0),
				checkCardinality("legalAgreement", o.getLegalAgreement()==null?0:o.getLegalAgreement().size(), 0, 0),
				checkCardinality("portfolioStateReference", o.getPortfolioStateReference()==null?0:o.getPortfolioStateReference().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Lineage", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Lineage", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

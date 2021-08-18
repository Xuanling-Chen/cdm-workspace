package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.CoveredTransactions;
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

public class CoveredTransactionsValidator implements Validator<CoveredTransactions> {

	@Override
	public ValidationResult<CoveredTransactions> validate(RosettaPath path, CoveredTransactions o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("inclusionDate", o.getInclusionDate()!=null ? 1 : 0, 1, 1),
				checkCardinality("coveredTransactions", o.getCoveredTransactions()==null?0:o.getCoveredTransactions().size(), 1, 0),
				checkCardinality("bespokeCoveredTransactions", o.getBespokeCoveredTransactions()==null?0:o.getBespokeCoveredTransactions().size(), 1, 0),
				checkCardinality("additionalObligations", o.getAdditionalObligations()==null?0:o.getAdditionalObligations().size(), 0, 2),
				checkCardinality("exposure", o.getExposure()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CoveredTransactions", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CoveredTransactions", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.IssuerCriteria;
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

public class IssuerCriteriaValidator implements Validator<IssuerCriteria> {

	@Override
	public ValidationResult<IssuerCriteria> validate(RosettaPath path, IssuerCriteria o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuerType", o.getIssuerType()==null?0:o.getIssuerType().size(), 0, 0),
				checkCardinality("issuerCountryOfOrigin", o.getIssuerCountryOfOrigin()==null?0:o.getIssuerCountryOfOrigin().size(), 0, 0),
				checkCardinality("issuerName", o.getIssuerName()==null?0:o.getIssuerName().size(), 0, 0),
				checkCardinality("issuerAgencyRating", o.getIssuerAgencyRating()==null?0:o.getIssuerAgencyRating().size(), 0, 0),
				checkCardinality("sovereignAgencyRating", o.getSovereignAgencyRating()==null?0:o.getSovereignAgencyRating().size(), 0, 0),
				checkCardinality("counterpartyOwnIssuePermitted", o.getCounterpartyOwnIssuePermitted()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("IssuerCriteria", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("IssuerCriteria", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

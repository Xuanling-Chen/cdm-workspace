package cdm.base.staticdata.asset.common.validation;

import cdm.base.staticdata.asset.common.Loan;
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

public class LoanValidator implements Validator<Loan> {

	@Override
	public ValidationResult<Loan> validate(RosettaPath path, Loan o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("borrower", o.getBorrower()==null?0:o.getBorrower().size(), 0, 0),
				checkCardinality("lien", o.getLien()!=null ? 1 : 0, 0, 1),
				checkCardinality("facilityType", o.getFacilityType()!=null ? 1 : 0, 0, 1),
				checkCardinality("creditAgreementDate", o.getCreditAgreementDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("tranche", o.getTranche()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Loan", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Loan", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

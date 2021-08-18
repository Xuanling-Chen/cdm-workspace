package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.CreditSupportDocumentElection;
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

public class CreditSupportDocumentElectionValidator implements Validator<CreditSupportDocumentElection> {

	@Override
	public ValidationResult<CreditSupportDocumentElection> validate(RosettaPath path, CreditSupportDocumentElection o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", o.getParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("creditSupportDocumentTerms", o.getCreditSupportDocumentTerms()!=null ? 1 : 0, 1, 1),
				checkCardinality("creditSupportDocument", o.getCreditSupportDocument()==null?0:o.getCreditSupportDocument().size(), 0, 0),
				checkCardinality("bespokeCreditSuppportDocument", o.getBespokeCreditSuppportDocument()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditSupportDocumentElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditSupportDocumentElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

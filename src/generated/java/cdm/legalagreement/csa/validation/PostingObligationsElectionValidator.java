package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.PostingObligationsElection;
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

public class PostingObligationsElectionValidator implements Validator<PostingObligationsElection> {

	@Override
	public ValidationResult<PostingObligationsElection> validate(RosettaPath path, PostingObligationsElection o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", o.getParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("asPermitted", o.getAsPermitted()!=null ? 1 : 0, 1, 1),
				checkCardinality("eligibleCollateral", o.getEligibleCollateral()==null?0:o.getEligibleCollateral().size(), 0, 0),
				checkCardinality("excludedCollateral", o.getExcludedCollateral()!=null ? 1 : 0, 0, 1),
				checkCardinality("additionalLanguage", o.getAdditionalLanguage()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("PostingObligationsElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("PostingObligationsElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

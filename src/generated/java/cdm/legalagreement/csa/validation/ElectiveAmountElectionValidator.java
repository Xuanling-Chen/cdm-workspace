package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.ElectiveAmountElection;
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

public class ElectiveAmountElectionValidator implements Validator<ElectiveAmountElection> {

	@Override
	public ValidationResult<ElectiveAmountElection> validate(RosettaPath path, ElectiveAmountElection o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", o.getParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("electiveAmount", o.getElectiveAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("amount", o.getAmount()!=null ? 1 : 0, 0, 1),
				checkCardinality("customElection", o.getCustomElection()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ElectiveAmountElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ElectiveAmountElection", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

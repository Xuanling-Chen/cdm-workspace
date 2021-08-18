package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.ContractualMatrix;
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

public class ContractualMatrixValidator implements Validator<ContractualMatrix> {

	@Override
	public ValidationResult<ContractualMatrix> validate(RosettaPath path, ContractualMatrix o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("matrixType", o.getMatrixType()!=null ? 1 : 0, 1, 1),
				checkCardinality("publicationDate", o.getPublicationDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("matrixTerm", o.getMatrixTerm()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ContractualMatrix", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ContractualMatrix", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

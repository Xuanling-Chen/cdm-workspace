package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.GeneralSimmElections;
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

public class GeneralSimmElectionsValidator implements Validator<GeneralSimmElections> {

	@Override
	public ValidationResult<GeneralSimmElections> validate(RosettaPath path, GeneralSimmElections o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("simmVersion", o.getSimmVersion()!=null ? 1 : 0, 0, 1),
				checkCardinality("simmCalculationCurrency", o.getSimmCalculationCurrency()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("GeneralSimmElections", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("GeneralSimmElections", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.regulation.validation;

import cdm.regulation.Othr;
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

public class OthrValidator implements Validator<Othr> {

	@Override
	public ValidationResult<Othr> validate(RosettaPath path, Othr o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("finInstrmGnlAttrbts", o.getFinInstrmGnlAttrbts()!=null ? 1 : 0, 1, 1),
				checkCardinality("derivInstrmAttrbts", o.getDerivInstrmAttrbts()!=null ? 1 : 0, 1, 1),
				checkCardinality("id", o.getId()!=null ? 1 : 0, 1, 1),
				checkCardinality("schmeNm", o.getSchmeNm()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Othr", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Othr", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

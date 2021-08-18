package cdm.regulation.validation;

import cdm.regulation.FinInstrmGnlAttrbts;
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

public class FinInstrmGnlAttrbtsValidator implements Validator<FinInstrmGnlAttrbts> {

	@Override
	public ValidationResult<FinInstrmGnlAttrbts> validate(RosettaPath path, FinInstrmGnlAttrbts o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("fullNm", o.getFullNm()!=null ? 1 : 0, 1, 1),
				checkCardinality("clssfctnTp", o.getClssfctnTp()!=null ? 1 : 0, 1, 1),
				checkCardinality("ntnlCcy", o.getNtnlCcy()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("FinInstrmGnlAttrbts", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("FinInstrmGnlAttrbts", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

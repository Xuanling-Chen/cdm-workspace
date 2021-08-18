package cdm.regulation.validation;

import cdm.regulation.UndrlygInstrm;
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

public class UndrlygInstrmValidator implements Validator<UndrlygInstrm> {

	@Override
	public ValidationResult<UndrlygInstrm> validate(RosettaPath path, UndrlygInstrm o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("swp", o.getSwp()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("UndrlygInstrm", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("UndrlygInstrm", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

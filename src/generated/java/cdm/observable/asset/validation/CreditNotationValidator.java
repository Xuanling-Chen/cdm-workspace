package cdm.observable.asset.validation;

import cdm.observable.asset.CreditNotation;
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

public class CreditNotationValidator implements Validator<CreditNotation> {

	@Override
	public ValidationResult<CreditNotation> validate(RosettaPath path, CreditNotation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("agency", o.getAgency()!=null ? 1 : 0, 1, 1),
				checkCardinality("notation", o.getNotation()!=null ? 1 : 0, 1, 1),
				checkCardinality("scale", o.getScale()!=null ? 1 : 0, 0, 1),
				checkCardinality("debt", o.getDebt()!=null ? 1 : 0, 0, 1),
				checkCardinality("outlook", o.getOutlook()!=null ? 1 : 0, 0, 1),
				checkCardinality("creditWatch", o.getCreditWatch()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CreditNotation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CreditNotation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

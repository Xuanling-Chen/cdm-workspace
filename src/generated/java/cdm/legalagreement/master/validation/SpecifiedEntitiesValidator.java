package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.SpecifiedEntities;
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

public class SpecifiedEntitiesValidator implements Validator<SpecifiedEntities> {

	@Override
	public ValidationResult<SpecifiedEntities> validate(RosettaPath path, SpecifiedEntities o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("specifiedEntityClause", o.getSpecifiedEntityClause()!=null ? 1 : 0, 1, 1),
				checkCardinality("specifiedEntity", o.getSpecifiedEntity()==null?0:o.getSpecifiedEntity().size(), 2, 2)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SpecifiedEntities", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SpecifiedEntities", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

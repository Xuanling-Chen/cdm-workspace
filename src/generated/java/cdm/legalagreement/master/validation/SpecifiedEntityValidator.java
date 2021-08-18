package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.SpecifiedEntity;
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

public class SpecifiedEntityValidator implements Validator<SpecifiedEntity> {

	@Override
	public ValidationResult<SpecifiedEntity> validate(RosettaPath path, SpecifiedEntity o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", o.getParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("specifiedEntityTerms", o.getSpecifiedEntityTerms()!=null ? 1 : 0, 1, 1),
				checkCardinality("specifiedEntity", o.getSpecifiedEntity()==null?0:o.getSpecifiedEntity().size(), 0, 0),
				checkCardinality("materialSubsidiaryTerms", o.getMaterialSubsidiaryTerms()!=null ? 1 : 0, 0, 1),
				checkCardinality("otherSpecifiedEntityTerms", o.getOtherSpecifiedEntityTerms()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("SpecifiedEntity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("SpecifiedEntity", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

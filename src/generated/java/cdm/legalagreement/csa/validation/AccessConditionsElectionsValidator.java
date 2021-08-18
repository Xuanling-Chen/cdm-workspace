package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.AccessConditionsElections;
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

public class AccessConditionsElectionsValidator implements Validator<AccessConditionsElections> {

	@Override
	public ValidationResult<AccessConditionsElections> validate(RosettaPath path, AccessConditionsElections o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("party", o.getParty()!=null ? 1 : 0, 1, 1),
				checkCardinality("illegality", o.getIllegality()!=null ? 1 : 0, 1, 1),
				checkCardinality("forceMajeure", o.getForceMajeure()!=null ? 1 : 0, 1, 1),
				checkCardinality("taxEvent", o.getTaxEvent()!=null ? 1 : 0, 1, 1),
				checkCardinality("taxEventUponMerger", o.getTaxEventUponMerger()!=null ? 1 : 0, 1, 1),
				checkCardinality("creditEventUponMerger", o.getCreditEventUponMerger()!=null ? 1 : 0, 1, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("AccessConditionsElections", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("AccessConditionsElections", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

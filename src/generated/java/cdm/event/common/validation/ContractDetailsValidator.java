package cdm.event.common.validation;

import cdm.event.common.ContractDetails;
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

public class ContractDetailsValidator implements Validator<ContractDetails> {

	@Override
	public ValidationResult<ContractDetails> validate(RosettaPath path, ContractDetails o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("documentation", o.getDocumentation()==null?0:o.getDocumentation().size(), 0, 0),
				checkCardinality("governingLaw", o.getGoverningLaw()!=null ? 1 : 0, 0, 1),
				checkCardinality("partyContractInformation", o.getPartyContractInformation()==null?0:o.getPartyContractInformation().size(), 0, 0),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("ContractDetails", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("ContractDetails", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

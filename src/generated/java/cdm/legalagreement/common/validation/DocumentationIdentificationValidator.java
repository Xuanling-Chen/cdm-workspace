package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.DocumentationIdentification;
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

public class DocumentationIdentificationValidator implements Validator<DocumentationIdentification> {

	@Override
	public ValidationResult<DocumentationIdentification> validate(RosettaPath path, DocumentationIdentification o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("masterAgreement", o.getMasterAgreement()!=null ? 1 : 0, 0, 1),
				checkCardinality("masterConfirmation", o.getMasterConfirmation()!=null ? 1 : 0, 0, 1),
				checkCardinality("brokerConfirmation", o.getBrokerConfirmation()!=null ? 1 : 0, 0, 1),
				checkCardinality("contractualDefinitions", o.getContractualDefinitions()==null?0:o.getContractualDefinitions().size(), 0, 0),
				checkCardinality("contractualTermsSupplement", o.getContractualTermsSupplement()==null?0:o.getContractualTermsSupplement().size(), 0, 0),
				checkCardinality("contractualMatrix", o.getContractualMatrix()==null?0:o.getContractualMatrix().size(), 0, 0),
				checkCardinality("creditSupportAgreement", o.getCreditSupportAgreement()!=null ? 1 : 0, 0, 1),
				checkCardinality("otherAgreement", o.getOtherAgreement()==null?0:o.getOtherAgreement().size(), 0, 0),
				checkCardinality("attachment", o.getAttachment()==null?0:o.getAttachment().size(), 0, 0)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DocumentationIdentification", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DocumentationIdentification", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

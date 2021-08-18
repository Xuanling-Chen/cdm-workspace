package cdm.legalagreement.master.validation;

import cdm.legalagreement.master.MasterAgreementSchedule;
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

public class MasterAgreementScheduleValidator implements Validator<MasterAgreementSchedule> {

	@Override
	public ValidationResult<MasterAgreementSchedule> validate(RosettaPath path, MasterAgreementSchedule o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("automaticEarlyTermination", o.getAutomaticEarlyTermination()!=null ? 1 : 0, 1, 1),
				checkCardinality("terminationCurrency", o.getTerminationCurrency()!=null ? 1 : 0, 1, 1),
				checkCardinality("addressForNotices", o.getAddressForNotices()!=null ? 1 : 0, 1, 1),
				checkCardinality("nonContractualObligations", o.getNonContractualObligations()!=null ? 1 : 0, 1, 1),
				checkCardinality("creditSupportDocument", o.getCreditSupportDocument()!=null ? 1 : 0, 1, 1),
				checkCardinality("creditSupportProvider", o.getCreditSupportProvider()!=null ? 1 : 0, 1, 1),
				checkCardinality("specifiedEntities", o.getSpecifiedEntities()==null?0:o.getSpecifiedEntities().size(), 4, 4)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("MasterAgreementSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("MasterAgreementSchedule", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

package cdm.legalagreement.csa.validation;

import cdm.legalagreement.csa.CustodyArrangements;
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

public class CustodyArrangementsValidator implements Validator<CustodyArrangements> {

	@Override
	public ValidationResult<CustodyArrangements> validate(RosettaPath path, CustodyArrangements o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("isCreditSupportDocument", o.getIsCreditSupportDocument()!=null ? 1 : 0, 0, 1),
				checkCardinality("hasControlAgreementLanguage", o.getHasControlAgreementLanguage()!=null ? 1 : 0, 0, 1),
				checkCardinality("otherProvisions", o.getOtherProvisions()!=null ? 1 : 0, 0, 1),
				checkCardinality("collateralAccessBreach", o.getCollateralAccessBreach()!=null ? 1 : 0, 0, 1),
				checkCardinality("custodianRisk", o.getCustodianRisk()!=null ? 1 : 0, 0, 1),
				checkCardinality("controlAgreement", o.getControlAgreement()!=null ? 1 : 0, 0, 1),
				checkCardinality("custodianEvent", o.getCustodianEvent()!=null ? 1 : 0, 1, 1),
				checkCardinality("custodian", o.getCustodian()!=null ? 1 : 0, 0, 1),
				checkCardinality("collateralManagementAgreeement", o.getCollateralManagementAgreeement()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("CustodyArrangements", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("CustodyArrangements", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

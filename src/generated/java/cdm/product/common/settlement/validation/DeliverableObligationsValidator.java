package cdm.product.common.settlement.validation;

import cdm.product.common.settlement.DeliverableObligations;
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

public class DeliverableObligationsValidator implements Validator<DeliverableObligations> {

	@Override
	public ValidationResult<DeliverableObligations> validate(RosettaPath path, DeliverableObligations o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("accruedInterest", o.getAccruedInterest()!=null ? 1 : 0, 0, 1),
				checkCardinality("category", o.getCategory()!=null ? 1 : 0, 0, 1),
				checkCardinality("notSubordinated", o.getNotSubordinated()!=null ? 1 : 0, 0, 1),
				checkCardinality("specifiedCurrency", o.getSpecifiedCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("notSovereignLender", o.getNotSovereignLender()!=null ? 1 : 0, 0, 1),
				checkCardinality("notDomesticCurrency", o.getNotDomesticCurrency()!=null ? 1 : 0, 0, 1),
				checkCardinality("notDomesticLaw", o.getNotDomesticLaw()!=null ? 1 : 0, 0, 1),
				checkCardinality("listed", o.getListed()!=null ? 1 : 0, 0, 1),
				checkCardinality("notContingent", o.getNotContingent()!=null ? 1 : 0, 0, 1),
				checkCardinality("notDomesticIssuance", o.getNotDomesticIssuance()!=null ? 1 : 0, 0, 1),
				checkCardinality("assignableLoan", o.getAssignableLoan()!=null ? 1 : 0, 0, 1),
				checkCardinality("consentRequiredLoan", o.getConsentRequiredLoan()!=null ? 1 : 0, 0, 1),
				checkCardinality("directLoanParticipation", o.getDirectLoanParticipation()!=null ? 1 : 0, 0, 1),
				checkCardinality("transferable", o.getTransferable()!=null ? 1 : 0, 0, 1),
				checkCardinality("maximumMaturity", o.getMaximumMaturity()!=null ? 1 : 0, 0, 1),
				checkCardinality("acceleratedOrMatured", o.getAcceleratedOrMatured()!=null ? 1 : 0, 0, 1),
				checkCardinality("notBearer", o.getNotBearer()!=null ? 1 : 0, 0, 1),
				checkCardinality("fullFaithAndCreditObLiability", o.getFullFaithAndCreditObLiability()!=null ? 1 : 0, 0, 1),
				checkCardinality("generalFundObligationLiability", o.getGeneralFundObligationLiability()!=null ? 1 : 0, 0, 1),
				checkCardinality("revenueObligationLiability", o.getRevenueObligationLiability()!=null ? 1 : 0, 0, 1),
				checkCardinality("indirectLoanParticipation", o.getIndirectLoanParticipation()!=null ? 1 : 0, 0, 1),
				checkCardinality("excluded", o.getExcluded()!=null ? 1 : 0, 0, 1),
				checkCardinality("othReferenceEntityObligations", o.getOthReferenceEntityObligations()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("DeliverableObligations", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("DeliverableObligations", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

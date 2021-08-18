package cdm.product.common.settlement.validation.exists;

import cdm.product.common.settlement.DeliverableObligations;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class DeliverableObligationsOnlyExistsValidator implements ValidatorWithArg<DeliverableObligations, Set<String>> {

	@Override
	public <T2 extends DeliverableObligations> ValidationResult<DeliverableObligations> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("accruedInterest", ExistenceChecker.isSet(o.getAccruedInterest()))
				.put("category", ExistenceChecker.isSet(o.getCategory()))
				.put("notSubordinated", ExistenceChecker.isSet(o.getNotSubordinated()))
				.put("specifiedCurrency", ExistenceChecker.isSet(o.getSpecifiedCurrency()))
				.put("notSovereignLender", ExistenceChecker.isSet(o.getNotSovereignLender()))
				.put("notDomesticCurrency", ExistenceChecker.isSet(o.getNotDomesticCurrency()))
				.put("notDomesticLaw", ExistenceChecker.isSet(o.getNotDomesticLaw()))
				.put("listed", ExistenceChecker.isSet(o.getListed()))
				.put("notContingent", ExistenceChecker.isSet(o.getNotContingent()))
				.put("notDomesticIssuance", ExistenceChecker.isSet(o.getNotDomesticIssuance()))
				.put("assignableLoan", ExistenceChecker.isSet(o.getAssignableLoan()))
				.put("consentRequiredLoan", ExistenceChecker.isSet(o.getConsentRequiredLoan()))
				.put("directLoanParticipation", ExistenceChecker.isSet(o.getDirectLoanParticipation()))
				.put("transferable", ExistenceChecker.isSet(o.getTransferable()))
				.put("maximumMaturity", ExistenceChecker.isSet(o.getMaximumMaturity()))
				.put("acceleratedOrMatured", ExistenceChecker.isSet(o.getAcceleratedOrMatured()))
				.put("notBearer", ExistenceChecker.isSet(o.getNotBearer()))
				.put("fullFaithAndCreditObLiability", ExistenceChecker.isSet(o.getFullFaithAndCreditObLiability()))
				.put("generalFundObligationLiability", ExistenceChecker.isSet(o.getGeneralFundObligationLiability()))
				.put("revenueObligationLiability", ExistenceChecker.isSet(o.getRevenueObligationLiability()))
				.put("indirectLoanParticipation", ExistenceChecker.isSet(o.getIndirectLoanParticipation()))
				.put("excluded", ExistenceChecker.isSet(o.getExcluded()))
				.put("othReferenceEntityObligations", ExistenceChecker.isSet(o.getOthReferenceEntityObligations()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DeliverableObligations", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("DeliverableObligations", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

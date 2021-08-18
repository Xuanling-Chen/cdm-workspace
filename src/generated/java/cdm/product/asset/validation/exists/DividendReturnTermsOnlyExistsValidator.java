package cdm.product.asset.validation.exists;

import cdm.product.asset.DividendReturnTerms;
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

public class DividendReturnTermsOnlyExistsValidator implements ValidatorWithArg<DividendReturnTerms, Set<String>> {

	@Override
	public <T2 extends DividendReturnTerms> ValidationResult<DividendReturnTerms> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("dividendPayout", ExistenceChecker.isSet(o.getDividendPayout()))
				.put("dividendReinvestment", ExistenceChecker.isSet(o.getDividendReinvestment()))
				.put("dividendEntitlement", ExistenceChecker.isSet(o.getDividendEntitlement()))
				.put("dividendAmountType", ExistenceChecker.isSet(o.getDividendAmountType()))
				.put("dividendPaymentDate", ExistenceChecker.isSet(o.getDividendPaymentDate()))
				.put("dividendPeriod", ExistenceChecker.isSet(o.getDividendPeriod()))
				.put("dividendPeriodEffectiveDate", ExistenceChecker.isSet(o.getDividendPeriodEffectiveDate()))
				.put("dividendPeriodEndDate", ExistenceChecker.isSet(o.getDividendPeriodEndDate()))
				.put("extraordinaryDividendsParty", ExistenceChecker.isSet(o.getExtraordinaryDividendsParty()))
				.put("excessDividendAmount", ExistenceChecker.isSet(o.getExcessDividendAmount()))
				.put("dividendCurrency", ExistenceChecker.isSet(o.getDividendCurrency()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DividendReturnTerms", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("DividendReturnTerms", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

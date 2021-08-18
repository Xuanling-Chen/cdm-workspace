package cdm.event.common.validation.exists;

import cdm.event.common.Lineage;
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

public class LineageOnlyExistsValidator implements ValidatorWithArg<Lineage, Set<String>> {

	@Override
	public <T2 extends Lineage> ValidationResult<Lineage> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeReference", ExistenceChecker.isSet(o.getTradeReference()))
				.put("eventReference", ExistenceChecker.isSet(o.getEventReference()))
				.put("cashflowReference", ExistenceChecker.isSet(o.getCashflowReference()))
				.put("creditDefaultPayoutReference", ExistenceChecker.isSet(o.getCreditDefaultPayoutReference()))
				.put("interestRatePayoutReference", ExistenceChecker.isSet(o.getInterestRatePayoutReference()))
				.put("optionPayoutReference", ExistenceChecker.isSet(o.getOptionPayoutReference()))
				.put("equityPayoutReference", ExistenceChecker.isSet(o.getEquityPayoutReference()))
				.put("transferReference", ExistenceChecker.isSet(o.getTransferReference()))
				.put("legalAgreement", ExistenceChecker.isSet(o.getLegalAgreement()))
				.put("portfolioStateReference", ExistenceChecker.isSet(o.getPortfolioStateReference()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Lineage", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Lineage", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

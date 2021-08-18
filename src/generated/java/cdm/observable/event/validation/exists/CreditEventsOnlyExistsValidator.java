package cdm.observable.event.validation.exists;

import cdm.observable.event.CreditEvents;
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

public class CreditEventsOnlyExistsValidator implements ValidatorWithArg<CreditEvents, Set<String>> {

	@Override
	public <T2 extends CreditEvents> ValidationResult<CreditEvents> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("bankruptcy", ExistenceChecker.isSet(o.getBankruptcy()))
				.put("failureToPay", ExistenceChecker.isSet(o.getFailureToPay()))
				.put("failureToPayPrincipal", ExistenceChecker.isSet(o.getFailureToPayPrincipal()))
				.put("failureToPayInterest", ExistenceChecker.isSet(o.getFailureToPayInterest()))
				.put("obligationDefault", ExistenceChecker.isSet(o.getObligationDefault()))
				.put("obligationAcceleration", ExistenceChecker.isSet(o.getObligationAcceleration()))
				.put("repudiationMoratorium", ExistenceChecker.isSet(o.getRepudiationMoratorium()))
				.put("restructuring", ExistenceChecker.isSet(o.getRestructuring()))
				.put("governmentalIntervention", ExistenceChecker.isSet(o.getGovernmentalIntervention()))
				.put("distressedRatingsDowngrade", ExistenceChecker.isSet(o.getDistressedRatingsDowngrade()))
				.put("maturityExtension", ExistenceChecker.isSet(o.getMaturityExtension()))
				.put("writedown", ExistenceChecker.isSet(o.getWritedown()))
				.put("impliedWritedown", ExistenceChecker.isSet(o.getImpliedWritedown()))
				.put("defaultRequirement", ExistenceChecker.isSet(o.getDefaultRequirement()))
				.put("creditEventNotice", ExistenceChecker.isSet(o.getCreditEventNotice()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CreditEvents", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CreditEvents", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.CoveredTransactions;
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

public class CoveredTransactionsOnlyExistsValidator implements ValidatorWithArg<CoveredTransactions, Set<String>> {

	@Override
	public <T2 extends CoveredTransactions> ValidationResult<CoveredTransactions> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("inclusionDate", ExistenceChecker.isSet(o.getInclusionDate()))
				.put("coveredTransactions", ExistenceChecker.isSet(o.getCoveredTransactions()))
				.put("bespokeCoveredTransactions", ExistenceChecker.isSet(o.getBespokeCoveredTransactions()))
				.put("additionalObligations", ExistenceChecker.isSet(o.getAdditionalObligations()))
				.put("exposure", ExistenceChecker.isSet(o.getExposure()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("CoveredTransactions", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("CoveredTransactions", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

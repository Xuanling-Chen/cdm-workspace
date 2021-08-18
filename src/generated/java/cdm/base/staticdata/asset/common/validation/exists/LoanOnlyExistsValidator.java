package cdm.base.staticdata.asset.common.validation.exists;

import cdm.base.staticdata.asset.common.Loan;
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

public class LoanOnlyExistsValidator implements ValidatorWithArg<Loan, Set<String>> {

	@Override
	public <T2 extends Loan> ValidationResult<Loan> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("borrower", ExistenceChecker.isSet(o.getBorrower()))
				.put("lien", ExistenceChecker.isSet(o.getLien()))
				.put("facilityType", ExistenceChecker.isSet(o.getFacilityType()))
				.put("creditAgreementDate", ExistenceChecker.isSet(o.getCreditAgreementDate()))
				.put("tranche", ExistenceChecker.isSet(o.getTranche()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Loan", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Loan", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

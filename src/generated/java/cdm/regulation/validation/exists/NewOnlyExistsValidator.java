package cdm.regulation.validation.exists;

import cdm.regulation.New;
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

public class NewOnlyExistsValidator implements ValidatorWithArg<New, Set<String>> {

	@Override
	public <T2 extends New> ValidationResult<New> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("txId", ExistenceChecker.isSet(o.getTxId()))
				.put("exctgPty", ExistenceChecker.isSet(o.getExctgPty()))
				.put("invstmtPtyInd", ExistenceChecker.isSet(o.getInvstmtPtyInd()))
				.put("submitgPty", ExistenceChecker.isSet(o.getSubmitgPty()))
				.put("buyr", ExistenceChecker.isSet(o.getBuyr()))
				.put("sellr", ExistenceChecker.isSet(o.getSellr()))
				.put("ordrTrnsmssn", ExistenceChecker.isSet(o.getOrdrTrnsmssn()))
				.put("tx", ExistenceChecker.isSet(o.getTx()))
				.put("finInstrm", ExistenceChecker.isSet(o.getFinInstrm()))
				.put("invstmtDcsnPrsn", ExistenceChecker.isSet(o.getInvstmtDcsnPrsn()))
				.put("exctgPrsn", ExistenceChecker.isSet(o.getExctgPrsn()))
				.put("addtlAttrbts", ExistenceChecker.isSet(o.getAddtlAttrbts()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("New", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("New", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

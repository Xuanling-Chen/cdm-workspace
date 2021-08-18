package cdm.regulation.validation.exists;

import cdm.regulation.DerivInstrmAttrbts;
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

public class DerivInstrmAttrbtsOnlyExistsValidator implements ValidatorWithArg<DerivInstrmAttrbts, Set<String>> {

	@Override
	public <T2 extends DerivInstrmAttrbts> ValidationResult<DerivInstrmAttrbts> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("xpryDt", ExistenceChecker.isSet(o.getXpryDt()))
				.put("pricMltplr", ExistenceChecker.isSet(o.getPricMltplr()))
				.put("undrlygInstrm", ExistenceChecker.isSet(o.getUndrlygInstrm()))
				.put("dlvryTp", ExistenceChecker.isSet(o.getDlvryTp()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DerivInstrmAttrbts", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("DerivInstrmAttrbts", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

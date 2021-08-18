package cdm.legalagreement.common.validation.exists;

import cdm.legalagreement.common.Resource;
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

public class ResourceOnlyExistsValidator implements ValidatorWithArg<Resource, Set<String>> {

	@Override
	public <T2 extends Resource> ValidationResult<Resource> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("resourceId", ExistenceChecker.isSet(o.getResourceId()))
				.put("resourceType", ExistenceChecker.isSet(o.getResourceType()))
				.put("language", ExistenceChecker.isSet(o.getLanguage()))
				.put("sizeInBytes", ExistenceChecker.isSet(o.getSizeInBytes()))
				.put("length", ExistenceChecker.isSet(o.getLength()))
				.put("mimeType", ExistenceChecker.isSet(o.getMimeType()))
				.put("name", ExistenceChecker.isSet(o.getName()))
				.put("comments", ExistenceChecker.isSet(o.getComments()))
				.put("string", ExistenceChecker.isSet(o.getString()))
				.put("url", ExistenceChecker.isSet(o.getUrl()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Resource", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Resource", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

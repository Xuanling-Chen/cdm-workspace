package cdm.product.asset.validation.exists;

import cdm.product.asset.IndexReferenceInformation;
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

public class IndexReferenceInformationOnlyExistsValidator implements ValidatorWithArg<IndexReferenceInformation, Set<String>> {

	@Override
	public <T2 extends IndexReferenceInformation> ValidationResult<IndexReferenceInformation> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("indexName", ExistenceChecker.isSet(o.getIndexName()))
				.put("indexId", ExistenceChecker.isSet(o.getIndexId()))
				.put("indexSeries", ExistenceChecker.isSet(o.getIndexSeries()))
				.put("indexAnnexVersion", ExistenceChecker.isSet(o.getIndexAnnexVersion()))
				.put("indexAnnexDate", ExistenceChecker.isSet(o.getIndexAnnexDate()))
				.put("indexAnnexSource", ExistenceChecker.isSet(o.getIndexAnnexSource()))
				.put("excludedReferenceEntity", ExistenceChecker.isSet(o.getExcludedReferenceEntity()))
				.put("tranche", ExistenceChecker.isSet(o.getTranche()))
				.put("settledEntityMatrix", ExistenceChecker.isSet(o.getSettledEntityMatrix()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("IndexReferenceInformation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("IndexReferenceInformation", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

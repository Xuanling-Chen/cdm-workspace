package cdm.legalagreement.common.validation.exists;

import cdm.legalagreement.common.DocumentationIdentification;
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

public class DocumentationIdentificationOnlyExistsValidator implements ValidatorWithArg<DocumentationIdentification, Set<String>> {

	@Override
	public <T2 extends DocumentationIdentification> ValidationResult<DocumentationIdentification> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("masterAgreement", ExistenceChecker.isSet(o.getMasterAgreement()))
				.put("masterConfirmation", ExistenceChecker.isSet(o.getMasterConfirmation()))
				.put("brokerConfirmation", ExistenceChecker.isSet(o.getBrokerConfirmation()))
				.put("contractualDefinitions", ExistenceChecker.isSet(o.getContractualDefinitions()))
				.put("contractualTermsSupplement", ExistenceChecker.isSet(o.getContractualTermsSupplement()))
				.put("contractualMatrix", ExistenceChecker.isSet(o.getContractualMatrix()))
				.put("creditSupportAgreement", ExistenceChecker.isSet(o.getCreditSupportAgreement()))
				.put("otherAgreement", ExistenceChecker.isSet(o.getOtherAgreement()))
				.put("attachment", ExistenceChecker.isSet(o.getAttachment()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DocumentationIdentification", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("DocumentationIdentification", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}

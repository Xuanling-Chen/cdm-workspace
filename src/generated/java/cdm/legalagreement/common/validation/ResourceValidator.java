package cdm.legalagreement.common.validation;

import cdm.legalagreement.common.Resource;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class ResourceValidator implements Validator<Resource> {

	@Override
	public ValidationResult<Resource> validate(RosettaPath path, Resource o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("resourceId", o.getResourceId()!=null ? 1 : 0, 1, 1),
				checkCardinality("resourceType", o.getResourceType()!=null ? 1 : 0, 0, 1),
				checkCardinality("language", o.getLanguage()!=null ? 1 : 0, 0, 1),
				checkCardinality("sizeInBytes", o.getSizeInBytes()!=null ? 1 : 0, 0, 1),
				checkCardinality("length", o.getLength()!=null ? 1 : 0, 0, 1),
				checkCardinality("mimeType", o.getMimeType()!=null ? 1 : 0, 0, 1),
				checkCardinality("name", o.getName()!=null ? 1 : 0, 0, 1),
				checkCardinality("comments", o.getComments()!=null ? 1 : 0, 0, 1),
				checkCardinality("string", o.getString()!=null ? 1 : 0, 0, 1),
				checkCardinality("url", o.getUrl()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Resource", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Resource", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

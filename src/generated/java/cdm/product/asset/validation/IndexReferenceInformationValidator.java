package cdm.product.asset.validation;

import cdm.product.asset.IndexReferenceInformation;
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

public class IndexReferenceInformationValidator implements Validator<IndexReferenceInformation> {

	@Override
	public ValidationResult<IndexReferenceInformation> validate(RosettaPath path, IndexReferenceInformation o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("indexName", o.getIndexName()!=null ? 1 : 0, 0, 1),
				checkCardinality("indexId", o.getIndexId()==null?0:o.getIndexId().size(), 0, 0),
				checkCardinality("indexSeries", o.getIndexSeries()!=null ? 1 : 0, 0, 1),
				checkCardinality("indexAnnexVersion", o.getIndexAnnexVersion()!=null ? 1 : 0, 0, 1),
				checkCardinality("indexAnnexDate", o.getIndexAnnexDate()!=null ? 1 : 0, 0, 1),
				checkCardinality("indexAnnexSource", o.getIndexAnnexSource()!=null ? 1 : 0, 0, 1),
				checkCardinality("excludedReferenceEntity", o.getExcludedReferenceEntity()==null?0:o.getExcludedReferenceEntity().size(), 0, 0),
				checkCardinality("tranche", o.getTranche()!=null ? 1 : 0, 0, 1),
				checkCardinality("settledEntityMatrix", o.getSettledEntityMatrix()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("IndexReferenceInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("IndexReferenceInformation", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

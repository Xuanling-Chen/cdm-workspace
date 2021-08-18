package cdm.product.asset.validation.datarule;

import cdm.product.asset.IndexReferenceInformation;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("IndexReferenceInformationIndexAnnexVersion")
public class IndexReferenceInformationIndexAnnexVersion implements Validator<IndexReferenceInformation> {
	
	private static final String NAME = "IndexReferenceInformationIndexAnnexVersion";
	private static final String DEFINITION = "if indexAnnexVersion exists then indexAnnexVersion >= 0";
	
	
	@Override
	public ValidationResult<IndexReferenceInformation> validate(RosettaPath path, IndexReferenceInformation indexReferenceInformation) {
		ComparisonResult result = executeDataRule(indexReferenceInformation);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "IndexReferenceInformation", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "IndexReferenceInformation", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(IndexReferenceInformation indexReferenceInformation) {
		if (ruleIsApplicable(indexReferenceInformation).get()) {
			return evaluateThenExpression(indexReferenceInformation);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(IndexReferenceInformation indexReferenceInformation) {
		try {
			return exists(MapperS.of(indexReferenceInformation).<Integer>map("getIndexAnnexVersion", _indexReferenceInformation -> _indexReferenceInformation.getIndexAnnexVersion()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(IndexReferenceInformation indexReferenceInformation) {
		try {
			return greaterThanEquals(MapperS.of(indexReferenceInformation).<Integer>map("getIndexAnnexVersion", _indexReferenceInformation -> _indexReferenceInformation.getIndexAnnexVersion()), MapperS.of(Integer.valueOf(0)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

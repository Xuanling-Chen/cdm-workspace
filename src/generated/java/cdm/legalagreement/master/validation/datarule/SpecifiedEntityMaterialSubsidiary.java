package cdm.legalagreement.master.validation.datarule;

import cdm.legalagreement.common.SpecifiedEntityTermsEnum;
import cdm.legalagreement.master.SpecifiedEntity;
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
@RosettaDataRule("SpecifiedEntityMaterialSubsidiary")
public class SpecifiedEntityMaterialSubsidiary implements Validator<SpecifiedEntity> {
	
	private static final String NAME = "SpecifiedEntityMaterialSubsidiary";
	private static final String DEFINITION = "if specifiedEntityTerms = SpecifiedEntityTermsEnum->MaterialSubsidiary then materialSubsidiaryTerms exists";
	
	
	@Override
	public ValidationResult<SpecifiedEntity> validate(RosettaPath path, SpecifiedEntity specifiedEntity) {
		ComparisonResult result = executeDataRule(specifiedEntity);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SpecifiedEntity", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SpecifiedEntity", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SpecifiedEntity specifiedEntity) {
		if (ruleIsApplicable(specifiedEntity).get()) {
			return evaluateThenExpression(specifiedEntity);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SpecifiedEntity specifiedEntity) {
		try {
			return areEqual(MapperS.of(specifiedEntity).<SpecifiedEntityTermsEnum>map("getSpecifiedEntityTerms", _specifiedEntity -> _specifiedEntity.getSpecifiedEntityTerms()), MapperS.of(SpecifiedEntityTermsEnum.MATERIAL_SUBSIDIARY), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SpecifiedEntity specifiedEntity) {
		try {
			return exists(MapperS.of(specifiedEntity).<String>map("getMaterialSubsidiaryTerms", _specifiedEntity -> _specifiedEntity.getMaterialSubsidiaryTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

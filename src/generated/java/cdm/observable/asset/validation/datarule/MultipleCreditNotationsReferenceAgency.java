package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import cdm.observable.asset.CreditRatingAgencyEnum;
import cdm.observable.asset.MultipleCreditNotations;
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
@RosettaDataRule("MultipleCreditNotationsReferenceAgency")
public class MultipleCreditNotationsReferenceAgency implements Validator<MultipleCreditNotations> {
	
	private static final String NAME = "MultipleCreditNotationsReferenceAgency";
	private static final String DEFINITION = "if MultipleCreditNotations -> mismatchResolution = CreditNotationMismatchResolutionEnum -> ReferenceAgency then MultipleCreditNotations -> referenceAgency exists";
	
	
	@Override
	public ValidationResult<MultipleCreditNotations> validate(RosettaPath path, MultipleCreditNotations multipleCreditNotations) {
		ComparisonResult result = executeDataRule(multipleCreditNotations);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "MultipleCreditNotations", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MultipleCreditNotations", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(MultipleCreditNotations multipleCreditNotations) {
		if (ruleIsApplicable(multipleCreditNotations).get()) {
			return evaluateThenExpression(multipleCreditNotations);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(MultipleCreditNotations multipleCreditNotations) {
		try {
			return areEqual(MapperS.of(multipleCreditNotations).<CreditNotationMismatchResolutionEnum>map("getMismatchResolution", _multipleCreditNotations -> _multipleCreditNotations.getMismatchResolution()), MapperS.of(CreditNotationMismatchResolutionEnum.REFERENCE_AGENCY), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(MultipleCreditNotations multipleCreditNotations) {
		try {
			return exists(MapperS.of(multipleCreditNotations).<CreditRatingAgencyEnum>map("getReferenceAgency", _multipleCreditNotations -> _multipleCreditNotations.getReferenceAgency()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

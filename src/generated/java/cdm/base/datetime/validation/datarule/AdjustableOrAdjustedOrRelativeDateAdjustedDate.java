package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.RelativeDateOffset;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.FieldWithMetaDate;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AdjustableOrAdjustedOrRelativeDateAdjustedDate")
public class AdjustableOrAdjustedOrRelativeDateAdjustedDate implements Validator<AdjustableOrAdjustedOrRelativeDate> {
	
	private static final String NAME = "AdjustableOrAdjustedOrRelativeDateAdjustedDate";
	private static final String DEFINITION = "if AdjustableOrAdjustedOrRelativeDate exists then adjustedDate exists or relativeDate exists or (unadjustedDate) exists or ((unadjustedDate and dateAdjustments) exists and adjustedDate is absent)";
	
	
	@Override
	public ValidationResult<AdjustableOrAdjustedOrRelativeDate> validate(RosettaPath path, AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate) {
		ComparisonResult result = executeDataRule(adjustableOrAdjustedOrRelativeDate);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AdjustableOrAdjustedOrRelativeDate", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrAdjustedOrRelativeDate", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate) {
		if (ruleIsApplicable(adjustableOrAdjustedOrRelativeDate).get()) {
			return evaluateThenExpression(adjustableOrAdjustedOrRelativeDate);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate) {
		try {
			return exists(MapperS.of(adjustableOrAdjustedOrRelativeDate));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AdjustableOrAdjustedOrRelativeDate adjustableOrAdjustedOrRelativeDate) {
		try {
			return exists(MapperS.of(adjustableOrAdjustedOrRelativeDate).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue())).or(exists(MapperS.of(adjustableOrAdjustedOrRelativeDate).<RelativeDateOffset>map("getRelativeDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getRelativeDate()))).or(exists(MapperS.of(adjustableOrAdjustedOrRelativeDate).<Date>map("getUnadjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getUnadjustedDate()))).or(exists(MapperTree.andDifferent(MapperTree.of(MapperS.of(adjustableOrAdjustedOrRelativeDate).<Date>map("getUnadjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getUnadjustedDate())), MapperTree.of(MapperS.of(adjustableOrAdjustedOrRelativeDate).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getDateAdjustments())))).and(notExists(MapperS.of(adjustableOrAdjustedOrRelativeDate).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

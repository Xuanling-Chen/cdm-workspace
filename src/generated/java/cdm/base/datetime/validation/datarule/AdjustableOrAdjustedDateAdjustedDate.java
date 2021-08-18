package cdm.base.datetime.validation.datarule;

import cdm.base.datetime.AdjustableOrAdjustedDate;
import cdm.base.datetime.BusinessDayAdjustments;
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
@RosettaDataRule("AdjustableOrAdjustedDateAdjustedDate")
public class AdjustableOrAdjustedDateAdjustedDate implements Validator<AdjustableOrAdjustedDate> {
	
	private static final String NAME = "AdjustableOrAdjustedDateAdjustedDate";
	private static final String DEFINITION = "if AdjustableOrAdjustedDate exists then adjustedDate exists or (unadjustedDate and dateAdjustments and adjustedDate) exists or ((unadjustedDate and dateAdjustments) exists and adjustedDate is absent)";
	
	
	@Override
	public ValidationResult<AdjustableOrAdjustedDate> validate(RosettaPath path, AdjustableOrAdjustedDate adjustableOrAdjustedDate) {
		ComparisonResult result = executeDataRule(adjustableOrAdjustedDate);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "AdjustableOrAdjustedDate", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrAdjustedDate", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(AdjustableOrAdjustedDate adjustableOrAdjustedDate) {
		if (ruleIsApplicable(adjustableOrAdjustedDate).get()) {
			return evaluateThenExpression(adjustableOrAdjustedDate);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(AdjustableOrAdjustedDate adjustableOrAdjustedDate) {
		try {
			return exists(MapperS.of(adjustableOrAdjustedDate));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(AdjustableOrAdjustedDate adjustableOrAdjustedDate) {
		try {
			return exists(MapperS.of(adjustableOrAdjustedDate).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue())).or(exists(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.of(MapperS.of(adjustableOrAdjustedDate).<Date>map("getUnadjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getUnadjustedDate())), MapperTree.of(MapperS.of(adjustableOrAdjustedDate).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getDateAdjustments()))), MapperTree.of(MapperS.of(adjustableOrAdjustedDate).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()))))).or(exists(MapperTree.andDifferent(MapperTree.of(MapperS.of(adjustableOrAdjustedDate).<Date>map("getUnadjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getUnadjustedDate())), MapperTree.of(MapperS.of(adjustableOrAdjustedDate).<BusinessDayAdjustments>map("getDateAdjustments", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getDateAdjustments())))).and(notExists(MapperS.of(adjustableOrAdjustedDate).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedDate -> _adjustableOrAdjustedDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

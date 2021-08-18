package cdm.product.asset.validation.datarule;

import cdm.product.asset.DividendPeriodEnum;
import cdm.product.asset.DividendReturnTerms;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.metafields.BasicReferenceWithMetaDate;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("DividendReturnTermsDividendPeriod")
public class DividendReturnTermsDividendPeriod implements Validator<DividendReturnTerms> {
	
	private static final String NAME = "DividendReturnTermsDividendPeriod";
	private static final String DEFINITION = "if dividendPeriod exists then dividendPeriodEffectiveDate is absent and dividendPeriodEndDate is absent";
	
	
	@Override
	public ValidationResult<DividendReturnTerms> validate(RosettaPath path, DividendReturnTerms dividendReturnTerms) {
		ComparisonResult result = executeDataRule(dividendReturnTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "DividendReturnTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendReturnTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(DividendReturnTerms dividendReturnTerms) {
		if (ruleIsApplicable(dividendReturnTerms).get()) {
			return evaluateThenExpression(dividendReturnTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(DividendReturnTerms dividendReturnTerms) {
		try {
			return exists(MapperS.of(dividendReturnTerms).<DividendPeriodEnum>map("getDividendPeriod", _dividendReturnTerms -> _dividendReturnTerms.getDividendPeriod()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(DividendReturnTerms dividendReturnTerms) {
		try {
			return notExists(MapperS.of(dividendReturnTerms).<BasicReferenceWithMetaDate>map("getDividendPeriodEffectiveDate", _dividendReturnTerms -> _dividendReturnTerms.getDividendPeriodEffectiveDate()).<Date>map("getValue", _f->_f.getValue())).and(notExists(MapperS.of(dividendReturnTerms).<BasicReferenceWithMetaDate>map("getDividendPeriodEndDate", _dividendReturnTerms -> _dividendReturnTerms.getDividendPeriodEndDate()).<Date>map("getValue", _f->_f.getValue())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

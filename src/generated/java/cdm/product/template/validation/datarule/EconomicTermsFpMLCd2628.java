package cdm.product.template.validation.datarule;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustedRelativeDateOffset;
import cdm.base.datetime.RelativeDateOffset;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
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
@RosettaDataRule("EconomicTermsFpML_cd_26_28")
public class EconomicTermsFpMLCd2628 implements Validator<EconomicTerms> {
	
	private static final String NAME = "EconomicTermsFpML_cd_26_28";
	private static final String DEFINITION = "if payout -> creditDefaultPayout exists and payout -> cashflow exists and effectiveDate exists and payout -> cashflow -> cashflowDate -> unadjustedDate exists and payout -> cashflow -> cashflowDate -> relativeDate is absent then payout -> cashflow -> cashflowDate -> unadjustedDate all > effectiveDate -> adjustableDate -> unadjustedDate or payout -> cashflow -> cashflowDate -> adjustedDate all > effectiveDate -> adjustableDate -> adjustedDate or payout -> cashflow -> cashflowDate -> relativeDate -> adjustedDate all > effectiveDate -> relativeDate -> adjustedDate";
	
	
	@Override
	public ValidationResult<EconomicTerms> validate(RosettaPath path, EconomicTerms economicTerms) {
		ComparisonResult result = executeDataRule(economicTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "EconomicTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
		if (ruleIsApplicable(economicTerms).get()) {
			return evaluateThenExpression(economicTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(EconomicTerms economicTerms) {
		try {
			return exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout())).and(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()))).and(exists(MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()))).and(exists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()).<Date>map("getUnadjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getUnadjustedDate()))).and(notExists(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()).<RelativeDateOffset>map("getRelativeDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getRelativeDate())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(EconomicTerms economicTerms) {
		try {
			return greaterThan(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()).<Date>map("getUnadjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getUnadjustedDate()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", _adjustableDate -> _adjustableDate.getUnadjustedDate()), CardinalityOperator.All).or(greaterThan(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getAdjustableDate()).<FieldWithMetaDate>map("getAdjustedDate", _adjustableDate -> _adjustableDate.getAdjustedDate()).<Date>map("getValue", _f->_f.getValue()), CardinalityOperator.All)).or(greaterThan(MapperS.of(economicTerms).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<Cashflow>mapC("getCashflow", _payout -> _payout.getCashflow()).<AdjustableOrAdjustedOrRelativeDate>map("getCashflowDate", _cashflow -> _cashflow.getCashflowDate()).<RelativeDateOffset>map("getRelativeDate", _adjustableOrAdjustedOrRelativeDate -> _adjustableOrAdjustedOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()), MapperS.of(economicTerms).<AdjustableOrRelativeDate>map("getEffectiveDate", _economicTerms -> _economicTerms.getEffectiveDate()).<AdjustedRelativeDateOffset>map("getRelativeDate", _adjustableOrRelativeDate -> _adjustableOrRelativeDate.getRelativeDate()).<Date>map("getAdjustedDate", _relativeDateOffset -> _relativeDateOffset.getAdjustedDate()), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

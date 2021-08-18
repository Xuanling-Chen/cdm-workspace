package cdm.event.common.validation.datarule;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.event.common.BillingSummary;
import cdm.event.common.RecordAmountTypeEnum;
import cdm.event.common.Transfer;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("BillingSummaryGrandTotal")
public class BillingSummaryGrandTotal implements Validator<BillingSummary> {
	
	private static final String NAME = "BillingSummaryGrandTotal";
	private static final String DEFINITION = "if summaryAmountType = RecordAmountTypeEnum -> GrandTotal then summaryTransfer exists and summaryTransfer -> payerReceiver is absent";
	
	
	@Override
	public ValidationResult<BillingSummary> validate(RosettaPath path, BillingSummary billingSummary) {
		ComparisonResult result = executeDataRule(billingSummary);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "BillingSummary", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "BillingSummary", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(BillingSummary billingSummary) {
		if (ruleIsApplicable(billingSummary).get()) {
			return evaluateThenExpression(billingSummary);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(BillingSummary billingSummary) {
		try {
			return areEqual(MapperS.of(billingSummary).<RecordAmountTypeEnum>map("getSummaryAmountType", _billingSummary -> _billingSummary.getSummaryAmountType()), MapperS.of(RecordAmountTypeEnum.GRAND_TOTAL), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(BillingSummary billingSummary) {
		try {
			return exists(MapperS.of(billingSummary).<Transfer>map("getSummaryTransfer", _billingSummary -> _billingSummary.getSummaryTransfer())).and(notExists(MapperS.of(billingSummary).<Transfer>map("getSummaryTransfer", _billingSummary -> _billingSummary.getSummaryTransfer()).<PartyReferencePayerReceiver>map("getPayerReceiver", _transfer -> _transfer.getPayerReceiver())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

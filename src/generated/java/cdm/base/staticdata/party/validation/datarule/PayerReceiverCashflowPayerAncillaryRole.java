package cdm.base.staticdata.party.validation.datarule;

import cdm.base.staticdata.party.AncillaryRoleEnum;
import cdm.base.staticdata.party.PayerReceiver;
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
@RosettaDataRule("PayerReceiverCashflowPayerAncillaryRole")
public class PayerReceiverCashflowPayerAncillaryRole implements Validator<PayerReceiver> {
	
	private static final String NAME = "PayerReceiverCashflowPayerAncillaryRole";
	private static final String DEFINITION = "if payerAncillaryRole exists then payerAncillaryRole = AncillaryRoleEnum -> ArrangingBroker or payerAncillaryRole = AncillaryRoleEnum -> Beneficiary or payerAncillaryRole = AncillaryRoleEnum -> ClearingFirm or payerAncillaryRole = AncillaryRoleEnum -> CounterpartyAfflilate or payerAncillaryRole = AncillaryRoleEnum -> Guarantor or payerAncillaryRole = AncillaryRoleEnum -> OtherParty or payerAncillaryRole = AncillaryRoleEnum -> PrimeBroker or payerAncillaryRole = AncillaryRoleEnum -> SettlementAgent";
	
	
	@Override
	public ValidationResult<PayerReceiver> validate(RosettaPath path, PayerReceiver payerReceiver) {
		ComparisonResult result = executeDataRule(payerReceiver);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PayerReceiver", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PayerReceiver", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PayerReceiver payerReceiver) {
		if (ruleIsApplicable(payerReceiver).get()) {
			return evaluateThenExpression(payerReceiver);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PayerReceiver payerReceiver) {
		try {
			return exists(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PayerReceiver payerReceiver) {
		try {
			return areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()), MapperS.of(AncillaryRoleEnum.ARRANGING_BROKER), CardinalityOperator.All).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()), MapperS.of(AncillaryRoleEnum.BENEFICIARY), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()), MapperS.of(AncillaryRoleEnum.CLEARING_FIRM), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()), MapperS.of(AncillaryRoleEnum.COUNTERPARTY_AFFLILATE), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()), MapperS.of(AncillaryRoleEnum.GUARANTOR), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()), MapperS.of(AncillaryRoleEnum.OTHER_PARTY), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()), MapperS.of(AncillaryRoleEnum.PRIME_BROKER), CardinalityOperator.All)).or(areEqual(MapperS.of(payerReceiver).<AncillaryRoleEnum>map("getPayerAncillaryRole", _payerReceiver -> _payerReceiver.getPayerAncillaryRole()), MapperS.of(AncillaryRoleEnum.SETTLEMENT_AGENT), CardinalityOperator.All));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

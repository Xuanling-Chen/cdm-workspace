package cdm.product.common.settlement.validation.datarule;

import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
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
@RosettaDataRule("SettlementTermsPhysicalSettlementTerms")
public class SettlementTermsPhysicalSettlementTerms implements Validator<SettlementTerms> {
	
	private static final String NAME = "SettlementTermsPhysicalSettlementTerms";
	private static final String DEFINITION = "if physicalSettlementTerms exists then settlementType <> SettlementTypeEnum -> Cash";
	
	
	@Override
	public ValidationResult<SettlementTerms> validate(RosettaPath path, SettlementTerms settlementTerms) {
		ComparisonResult result = executeDataRule(settlementTerms);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "SettlementTerms", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementTerms", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(SettlementTerms settlementTerms) {
		if (ruleIsApplicable(settlementTerms).get()) {
			return evaluateThenExpression(settlementTerms);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(SettlementTerms settlementTerms) {
		try {
			return exists(MapperS.of(settlementTerms).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(SettlementTerms settlementTerms) {
		try {
			return notEqual(MapperS.of(settlementTerms).<SettlementTypeEnum>map("getSettlementType", _settlementBase -> _settlementBase.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.Any);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

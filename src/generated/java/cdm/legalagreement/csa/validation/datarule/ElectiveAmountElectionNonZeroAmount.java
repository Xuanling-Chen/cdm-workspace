package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.ElectiveAmountElection;
import cdm.legalagreement.csa.ElectiveAmountEnum;
import cdm.observable.asset.Money;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ElectiveAmountElectionNonZeroAmount")
public class ElectiveAmountElectionNonZeroAmount implements Validator<ElectiveAmountElection> {
	
	private static final String NAME = "ElectiveAmountElectionNonZeroAmount";
	private static final String DEFINITION = "if electiveAmount is absent then (amount or customElection) exists";
	
	
	@Override
	public ValidationResult<ElectiveAmountElection> validate(RosettaPath path, ElectiveAmountElection electiveAmountElection) {
		ComparisonResult result = executeDataRule(electiveAmountElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ElectiveAmountElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ElectiveAmountElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ElectiveAmountElection electiveAmountElection) {
		if (ruleIsApplicable(electiveAmountElection).get()) {
			return evaluateThenExpression(electiveAmountElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ElectiveAmountElection electiveAmountElection) {
		try {
			return notExists(MapperS.of(electiveAmountElection).<ElectiveAmountEnum>map("getElectiveAmount", _electiveAmountElection -> _electiveAmountElection.getElectiveAmount()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ElectiveAmountElection electiveAmountElection) {
		try {
			return exists(MapperTree.orDifferent(MapperTree.of(MapperS.of(electiveAmountElection).<Money>map("getAmount", _electiveAmountElection -> _electiveAmountElection.getAmount())), MapperTree.of(MapperS.of(electiveAmountElection).<String>map("getCustomElection", _electiveAmountElection -> _electiveAmountElection.getCustomElection()))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

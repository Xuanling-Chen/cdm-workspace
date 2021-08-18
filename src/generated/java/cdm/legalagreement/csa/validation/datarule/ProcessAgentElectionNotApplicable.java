package cdm.legalagreement.csa.validation.datarule;

import cdm.base.staticdata.party.PartyContactInformation;
import cdm.legalagreement.csa.ProcessAgentElection;
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
@RosettaDataRule("ProcessAgentElectionNotApplicable")
public class ProcessAgentElectionNotApplicable implements Validator<ProcessAgentElection> {
	
	private static final String NAME = "ProcessAgentElectionNotApplicable";
	private static final String DEFINITION = "if isApplicable = False then processAgent is absent";
	
	
	@Override
	public ValidationResult<ProcessAgentElection> validate(RosettaPath path, ProcessAgentElection processAgentElection) {
		ComparisonResult result = executeDataRule(processAgentElection);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "ProcessAgentElection", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ProcessAgentElection", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(ProcessAgentElection processAgentElection) {
		if (ruleIsApplicable(processAgentElection).get()) {
			return evaluateThenExpression(processAgentElection);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(ProcessAgentElection processAgentElection) {
		try {
			return areEqual(MapperS.of(processAgentElection).<Boolean>map("getIsApplicable", _processAgentElection -> _processAgentElection.getIsApplicable()), MapperS.of(Boolean.valueOf(false)), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(ProcessAgentElection processAgentElection) {
		try {
			return notExists(MapperS.of(processAgentElection).<PartyContactInformation>map("getProcessAgent", _processAgentElection -> _processAgentElection.getProcessAgent()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

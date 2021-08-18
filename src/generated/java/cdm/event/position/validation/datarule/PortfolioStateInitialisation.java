package cdm.event.position.validation.datarule;

import cdm.event.common.Lineage;
import cdm.event.position.PortfolioState;
import cdm.event.position.Position;
import cdm.event.position.metafields.ReferenceWithMetaPortfolioState;
import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("PortfolioStateInitialisation")
public class PortfolioStateInitialisation implements Validator<PortfolioState> {
	
	private static final String NAME = "PortfolioStateInitialisation";
	private static final String DEFINITION = "if PortfolioState exists and lineage -> portfolioStateReference is absent then positions is absent and lineage -> eventReference is absent";
	
	
	@Override
	public ValidationResult<PortfolioState> validate(RosettaPath path, PortfolioState portfolioState) {
		ComparisonResult result = executeDataRule(portfolioState);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PortfolioState", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioState", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PortfolioState portfolioState) {
		if (ruleIsApplicable(portfolioState).get()) {
			return evaluateThenExpression(portfolioState);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PortfolioState portfolioState) {
		try {
			return exists(MapperS.of(portfolioState)).and(notExists(MapperS.of(portfolioState).<Lineage>map("getLineage", _portfolioState -> _portfolioState.getLineage()).<ReferenceWithMetaPortfolioState>mapC("getPortfolioStateReference", _lineage -> _lineage.getPortfolioStateReference()).<PortfolioState>map("getValue", _f->_f.getValue())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PortfolioState portfolioState) {
		try {
			return notExists(MapperS.of(portfolioState).<Position>mapC("getPositions", _portfolioState -> _portfolioState.getPositions())).and(notExists(MapperS.of(portfolioState).<Lineage>map("getLineage", _portfolioState -> _portfolioState.getLineage()).<ReferenceWithMetaWorkflowStep>mapC("getEventReference", _lineage -> _lineage.getEventReference()).<WorkflowStep>map("getValue", _f->_f.getValue())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}

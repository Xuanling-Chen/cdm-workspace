package cdm.event.common.meta;

import cdm.event.common.BusinessEvent;
import cdm.event.common.functions.Qualify_Allocation;
import cdm.event.common.functions.Qualify_CashAndSecurityTransfer;
import cdm.event.common.functions.Qualify_CashTransfer;
import cdm.event.common.functions.Qualify_ClearedTrade;
import cdm.event.common.functions.Qualify_ClearingRejection;
import cdm.event.common.functions.Qualify_ClearingSubmission;
import cdm.event.common.functions.Qualify_Compression;
import cdm.event.common.functions.Qualify_ContractFormation;
import cdm.event.common.functions.Qualify_Execution;
import cdm.event.common.functions.Qualify_Exercise;
import cdm.event.common.functions.Qualify_FullReturn;
import cdm.event.common.functions.Qualify_Increase;
import cdm.event.common.functions.Qualify_IndexTransition;
import cdm.event.common.functions.Qualify_MultipleTransfers;
import cdm.event.common.functions.Qualify_Novation;
import cdm.event.common.functions.Qualify_PartialNovation;
import cdm.event.common.functions.Qualify_PartialTermination;
import cdm.event.common.functions.Qualify_Reallocation;
import cdm.event.common.functions.Qualify_Reset;
import cdm.event.common.functions.Qualify_SecuritySettlement;
import cdm.event.common.functions.Qualify_SecurityTransfer;
import cdm.event.common.functions.Qualify_StockSplit;
import cdm.event.common.functions.Qualify_Termination;
import cdm.event.common.functions.Qualify_TradeWarehousePositionNotification;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @version ${project.version}
 */
@RosettaMeta(model=BusinessEvent.class)
public class BusinessEventMeta implements RosettaMetaData<BusinessEvent> {

	@Override
	public List<Validator<? super BusinessEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.event.common.validation.datarule.BusinessEventIntent.class)
		);
	}

	@Override
	public List<Validator<? super BusinessEvent>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BusinessEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Arrays.asList(
			factory.create(Qualify_Allocation.class),
			factory.create(Qualify_CashTransfer.class),
			factory.create(Qualify_CashAndSecurityTransfer.class),
			factory.create(Qualify_ClearedTrade.class),
			factory.create(Qualify_ClearingRejection.class),
			factory.create(Qualify_ClearingSubmission.class),
			factory.create(Qualify_Compression.class),
			factory.create(Qualify_Exercise.class),
			factory.create(Qualify_Increase.class),
			factory.create(Qualify_MultipleTransfers.class),
			factory.create(Qualify_Novation.class),
			factory.create(Qualify_PartialNovation.class),
			factory.create(Qualify_PartialTermination.class),
			factory.create(Qualify_Reset.class),
			factory.create(Qualify_SecurityTransfer.class),
			factory.create(Qualify_SecuritySettlement.class),
			factory.create(Qualify_Termination.class),
			factory.create(Qualify_TradeWarehousePositionNotification.class),
			factory.create(Qualify_Execution.class),
			factory.create(Qualify_ContractFormation.class),
			factory.create(Qualify_StockSplit.class),
			factory.create(Qualify_IndexTransition.class),
			factory.create(Qualify_FullReturn.class),
			factory.create(Qualify_Reallocation.class)
		);
	}
	
	@Override
	public Validator<? super BusinessEvent> validator() {
		return new cdm.event.common.validation.BusinessEventValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BusinessEvent, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.BusinessEventOnlyExistsValidator();
	}
}

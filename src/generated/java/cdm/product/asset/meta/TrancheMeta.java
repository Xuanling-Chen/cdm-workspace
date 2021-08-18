package cdm.product.asset.meta;

import cdm.product.asset.Tranche;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @version ${project.version}
 */
@RosettaMeta(model=Tranche.class)
public class TrancheMeta implements RosettaMetaData<Tranche> {

	@Override
	public List<Validator<? super Tranche>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.asset.validation.datarule.TrancheAttachmentPoint.class),
			factory.create(cdm.product.asset.validation.datarule.TrancheExhaustionPoint.class),
			factory.create(cdm.product.asset.validation.datarule.TrancheAttachmentPointLessThanExhaustionPoint.class)
		);
	}

	@Override
	public List<Validator<? super Tranche>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Tranche, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Tranche> validator() {
		return new cdm.product.asset.validation.TrancheValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Tranche, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.TrancheOnlyExistsValidator();
	}
}

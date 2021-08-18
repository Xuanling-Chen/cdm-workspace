package cdm.event.common.meta;

import cdm.event.common.TransferorTransferee;
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
@RosettaMeta(model=TransferorTransferee.class)
public class TransferorTransfereeMeta implements RosettaMetaData<TransferorTransferee> {

	@Override
	public List<Validator<? super TransferorTransferee>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super TransferorTransferee>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransferorTransferee, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransferorTransferee> validator() {
		return new cdm.event.common.validation.TransferorTransfereeValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransferorTransferee, Set<String>> onlyExistsValidator() {
		return new cdm.event.common.validation.exists.TransferorTransfereeOnlyExistsValidator();
	}
}

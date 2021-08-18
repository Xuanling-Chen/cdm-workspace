package cdm.product.asset.meta;

import cdm.product.asset.IndexReferenceInformation;
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
@RosettaMeta(model=IndexReferenceInformation.class)
public class IndexReferenceInformationMeta implements RosettaMetaData<IndexReferenceInformation> {

	@Override
	public List<Validator<? super IndexReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.create(cdm.product.asset.validation.datarule.IndexReferenceInformationIndexSeries.class),
			factory.create(cdm.product.asset.validation.datarule.IndexReferenceInformationIndexAnnexVersion.class)
		);
	}

	@Override
	public List<Validator<? super IndexReferenceInformation>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IndexReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IndexReferenceInformation> validator() {
		return new cdm.product.asset.validation.IndexReferenceInformationValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IndexReferenceInformation, Set<String>> onlyExistsValidator() {
		return new cdm.product.asset.validation.exists.IndexReferenceInformationOnlyExistsValidator();
	}
}

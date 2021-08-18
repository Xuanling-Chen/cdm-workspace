package cdm.base.staticdata.party.validation;

import cdm.base.staticdata.party.Account;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;

public class AccountValidator implements Validator<Account> {

	@Override
	public ValidationResult<Account> validate(RosettaPath path, Account o) {
		String error = 
			Lists.<ComparisonResult>newArrayList(
				checkCardinality("partyReference", o.getPartyReference()!=null ? 1 : 0, 0, 1),
				checkCardinality("accountNumber", o.getAccountNumber()!=null ? 1 : 0, 1, 1),
				checkCardinality("accountName", o.getAccountName()!=null ? 1 : 0, 0, 1),
				checkCardinality("accountType", o.getAccountType()!=null ? 1 : 0, 0, 1),
				checkCardinality("accountBeneficiary", o.getAccountBeneficiary()!=null ? 1 : 0, 0, 1),
				checkCardinality("servicingParty", o.getServicingParty()!=null ? 1 : 0, 0, 1),
				checkCardinality("meta", o.getMeta()!=null ? 1 : 0, 0, 1)
			).stream().filter(res -> !res.get()).map(res -> res.getError()).collect(joining("; "));
		
		if (!isNullOrEmpty(error)) {
			return failure("Account", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "", error);
		}
		return success("Account", ValidationType.MODEL_INSTANCE, o.getClass().getSimpleName(), path, "");
	}

}

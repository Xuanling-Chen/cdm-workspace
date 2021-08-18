package cdm.base.staticdata.party.metafields;

import cdm.base.staticdata.party.Account;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilderImpl;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaAccount.ReferenceWithMetaAccountImpl;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.ReferenceWithMeta;
import com.rosetta.model.lib.meta.ReferenceWithMeta.ReferenceWithMetaBuilder;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface ReferenceWithMetaAccount extends RosettaModelObject, ReferenceWithMeta<Account> {
	ReferenceWithMetaAccount build();
	ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder toBuilder();
	
	/**
	 */
	String getExternalReference();
	/**
	 */
	String getGlobalReference();
	/**
	 */
	Reference getReference();
	/**
	 */
	Account getValue();
	final static ReferenceWithMetaAccountMeta metaData = new ReferenceWithMetaAccountMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaAccount> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder builder() {
		return new ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaAccount> getType() {
		return ReferenceWithMetaAccount.class;
	}
	
		default Class<Account> getValueType() {
			return Account.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, Account.class, getValue());
	}
	
	
	interface ReferenceWithMetaAccountBuilder extends ReferenceWithMetaAccount, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<Account> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		Account.AccountBuilder getOrCreateValue();
		Account.AccountBuilder getValue();
		ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder setExternalReference(String externalReference);
		ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder setReference(Reference reference);
		ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder setValue(Account value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, Account.AccountBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaAccount.ReferenceWithMetaAccountImpl
	class ReferenceWithMetaAccountImpl implements ReferenceWithMetaAccount {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final Account value;
		
		protected ReferenceWithMetaAccountImpl(ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder builder) {
			this.externalReference = builder.getExternalReference();
			this.globalReference = builder.getGlobalReference();
			this.reference = ofNullable(builder.getReference()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getExternalReference() {
			return externalReference;
		}
		
		@Override
		public String getGlobalReference() {
			return globalReference;
		}
		
		@Override
		public Reference getReference() {
			return reference;
		}
		
		@Override
		public Account getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaAccount build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder toBuilder() {
			ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaAccount _that = getType().cast(o);
		
			if (!Objects.equals(externalReference, _that.getExternalReference())) return false;
			if (!Objects.equals(globalReference, _that.getGlobalReference())) return false;
			if (!Objects.equals(reference, _that.getReference())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalReference != null ? externalReference.hashCode() : 0);
			_result = 31 * _result + (globalReference != null ? globalReference.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceWithMetaAccount {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilderImpl
	class ReferenceWithMetaAccountBuilderImpl implements ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected Account.AccountBuilder value;
	
		public ReferenceWithMetaAccountBuilderImpl() {
		}
	
		@Override
		public String getExternalReference() {
			return externalReference;
		}
		
		@Override
		public String getGlobalReference() {
			return globalReference;
		}
		
		@Override
		public Reference.ReferenceBuilder getReference() {
			return reference;
		}
		
		@Override
		public Reference.ReferenceBuilder getOrCreateReference() {
			Reference.ReferenceBuilder result;
			if (reference!=null) {
				result = reference;
			}
			else {
				result = reference = Reference.builder();
			}
			
			return result;
		}
		
		@Override
		public Account.AccountBuilder getValue() {
			return value;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateValue() {
			Account.AccountBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = Account.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder setValue(Account value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaAccount build() {
			return new ReferenceWithMetaAccount.ReferenceWithMetaAccountImpl(this);
		}
		
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder prune() {
			if (reference!=null && !reference.prune().hasData()) reference = null;
			if (value!=null && !value.prune().hasData()) value = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalReference()!=null) return true;
			if (getGlobalReference()!=null) return true;
			if (getReference()!=null && getReference().hasData()) return true;
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder o = (ReferenceWithMetaAccount.ReferenceWithMetaAccountBuilder) other;
			
			merger.mergeRosetta(getReference(), o.getReference(), this::setReference);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			merger.mergeBasic(getExternalReference(), o.getExternalReference(), this::setExternalReference);
			merger.mergeBasic(getGlobalReference(), o.getGlobalReference(), this::setGlobalReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaAccount _that = getType().cast(o);
		
			if (!Objects.equals(externalReference, _that.getExternalReference())) return false;
			if (!Objects.equals(globalReference, _that.getGlobalReference())) return false;
			if (!Objects.equals(reference, _that.getReference())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalReference != null ? externalReference.hashCode() : 0);
			_result = 31 * _result + (globalReference != null ? globalReference.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceWithMetaAccountBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaAccountMeta extends BasicRosettaMetaData<ReferenceWithMetaAccount>{

}
